//package com.example.bai1
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.runtime.Composable
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.compose.*
//import com.example.bai1.data.TaskDatabase
//import com.example.bai1.repository.TaskRepository
//import com.example.bai1.ui.AddTaskScreen
//import com.example.bai1.ui.TaskListScreen
//import com.example.bai1.viewmodel.TaskViewModel
//import com.example.bai1.viewmodel.TaskViewModelFactory
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val database = TaskDatabase.getDatabase(applicationContext)
//        val repository = TaskRepository(database.taskDao())
//        val viewModelFactory = TaskViewModelFactory(repository)
//        val viewModel: TaskViewModel = viewModel(factory = viewModelFactory)
//
//        setContent {
//            SmartTasksApp()
//        }
//    }
//}
//
//@Composable
//fun SmartTasksApp(taskViewModel: TaskViewModel = viewModel())
//{
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "list")
//    {
//        composable("list") {
//            TaskListScreen(navController, taskViewModel)
//        }
//        composable("add") {
//            AddTaskScreen(navController, taskViewModel)
//        }
//    }
//}
//
//
package com.example.bai1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bai1.viewmodel.TaskViewModel
import com.example.bai1.viewmodel.TaskViewModelFactory
import androidx.navigation.compose.*
import com.example.bai1.ui.AddTaskScreen
import com.example.bai1.ui.TaskListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val taskViewModel: TaskViewModel = viewModel(
                factory = TaskViewModelFactory(application)
            )
            val navController = rememberNavController()

            NavHost(navController, startDestination = "list") {
                composable("list") {
                    TaskListScreen(navController = navController, viewModel = taskViewModel)
                }
                composable("add") {
                    AddTaskScreen(navController = navController, viewModel = taskViewModel)
                }
            }
        }
    }
}
