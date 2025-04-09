package com.example.bai1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bai1.viewmodel.TaskViewModel

@Composable
fun AddTaskScreen(
    navController: NavController,
    viewModel: TaskViewModel
) {
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding( 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 10.dp),
                    contentAlignment = Alignment.Center
                ) {

                    // Title ở giữa
                    Text(
                        text = "Add New",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2196F3)
                    )

                    // Nút Back icon bo tròn bên trái
                    IconButton(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .size(25.dp)
                            .background(Color(0xFF2196F3), shape = RoundedCornerShape(40))
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 24.dp)
                    .padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Task",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                OutlinedTextField(
                    value = taskTitle,
                    onValueChange = { taskTitle = it },
                    placeholder = { Text("Do homework") },
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = "Description",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                OutlinedTextField(
                    value = taskDescription,
                    onValueChange = { taskDescription = it },
                    placeholder = { Text("Don't give up") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (taskTitle.isNotEmpty()) {
                            viewModel.addTask(taskTitle, taskDescription)
                            navController.navigateUp()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF2196F3),
                        contentColor = Color.Blue
                    )
                ) {
                    Text("Add", fontSize = 18.sp)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AddTaskScreenPreview() {
    val navController = rememberNavController()
    val viewModel = TaskViewModel()
    AddTaskScreen(navController = navController, viewModel = viewModel)
}
