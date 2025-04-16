package com.example.bai1.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bai1.data.TaskDatabase
import com.example.bai1.repository.TaskRepository

class TaskViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val database = TaskDatabase.getDatabase(application)
        val repository = TaskRepository(database.taskDao())
        return TaskViewModel(repository) as T
    }
}
