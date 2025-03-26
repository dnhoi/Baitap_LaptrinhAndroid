//package com.example.bai1.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.bai1.api.RetrofitInstance
//import com.example.bai1.model.Task
//import kotlinx.coroutines.launch
//
//class TaskViewModel : ViewModel() {
//    private val _tasks = MutableLiveData<List<Task>>()
//    val tasks: LiveData<List<Task>> = _tasks
//
//    init {
//        getTasks()
//    }
//
//    private fun getTasks() {
//        viewModelScope.launch {
//            try {
//                val response = RetrofitInstance.api.getTasks()
//                if (response.isSuccessful) {
//                    val taskResponse: TaskResponse? = response.body()
//                    _tasks.value = taskResponse?.data
//                } else {
//                    // Handle the error (e.g., log the error)
//                    println("Error: ${response.code()}")
//                }
//            } catch (e: Exception) {
//                // Handle exceptions (e.g., log the exception)
//                println("Exception: ${e.message}")
//            }
//        }
//    }
//}



package com.example.bai1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bai1.api.RetrofitInstance
import com.example.bai1.model.Task
import com.example.bai1.model.TaskResponse // Thêm import này
import kotlinx.coroutines.launch




class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> = _tasks

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTasks()
                if (response.isSuccessful) {
                    _tasks.value = response.body()?.data ?: emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
