package com.example.bai3


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    data class UiState(
        val tasks: List<Task> = emptyList(),
        val selectedTask: Task? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String? = null
    )

    private val _uiState = MutableStateFlow(UiState(isLoading = true))
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchTasks()
    }

    fun fetchTasks() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)
                Log.d("TaskViewModel", "Fetching tasks from API...")
                val response = RetrofitClient.taskApiService.getTasks()
                Log.d("TaskViewModel", "Response received: $response")
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    Log.d("TaskViewModel", "API Response Body: $apiResponse")
                    if (apiResponse?.isSuccess == true) {
                        Log.d("TaskViewModel", "Tasks loaded: ${apiResponse.data}")
                        _uiState.value = _uiState.value.copy(
                            tasks = apiResponse.data,
                            isLoading = false,
                            isError = false
                        )
                        // Cập nhật lại selectedTask nếu đã chọn trước đó
                        _uiState.value.selectedTask?.let { selected ->
                            val updatedTask = apiResponse.data.find { it.id == selected.id }
                            _uiState.value = _uiState.value.copy(selectedTask = updatedTask)
                        }
                    } else {
                        Log.e("TaskViewModel", "API Error: ${apiResponse?.message}")
                        _uiState.value = _uiState.value.copy(
                            isError = true,
                            errorMessage = apiResponse?.message ?: "API failed",
                            isLoading = false
                        )
                    }
                } else {
                    Log.e("TaskViewModel", "HTTP Error: ${response.code()} - ${response.message()}")
                    _uiState.value = _uiState.value.copy(
                        isError = true,
                        errorMessage = "HTTP Error: ${response.code()}",
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Log.e("TaskViewModel", "Exception: ${e.message}", e)
                _uiState.value = _uiState.value.copy(
                    isError = true,
                    errorMessage = "Exception: ${e.message}",
                    isLoading = false
                )
            }
        }
    }

    fun refresh() {
        fetchTasks()
    }

    fun selectTask(taskId: Int) {
        Log.d("TaskViewModel", "Selecting task with ID: $taskId")
        val task = _uiState.value.tasks.find { it.id == taskId }
        Log.d("TaskViewModel", "Selected task: $task")
        _uiState.value = _uiState.value.copy(selectedTask = task)
    }
}
