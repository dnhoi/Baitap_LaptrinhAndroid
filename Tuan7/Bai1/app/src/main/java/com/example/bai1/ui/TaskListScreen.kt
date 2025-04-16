package com.example.bai1.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bai1.viewmodel.TaskViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TaskListScreen(navController: NavController, viewModel: TaskViewModel) {
    //val tasks = viewModel.tasks.value
    val tasks = viewModel.tasks.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.padding(top = 32.dp),
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Scaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Nút Back
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

                    // Tiêu đề
                    Text(
                        text = "List",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2196F3)
                    )

                    // Nút Add
                    IconButton(
                        onClick = { navController.navigate("add") },
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(25.dp)
                            .background(Color(0xFF2196F3), shape = RoundedCornerShape(50))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color.White
                        )
                    }
                }
            },

            bottomBar = {
                BottomAppBar(backgroundColor = Color.White) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.DateRange,
                                contentDescription = "Calendar"
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .padding(4.dp)
                        ) {
                            FloatingActionButton(
                                onClick = { navController.navigate("add") },
                                backgroundColor = Color(0xFF2196F3)
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = "Add Task",

                                    tint = Color.White
                                )
                            }
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = "Documents"
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Settings,
                                contentDescription = "Settings"
                            )
                        }
                    }
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(
                        horizontal = 24.dp,
                        vertical = 16.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(tasks) { task ->
                    TaskItem(task = task)
                }
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun TaskListScreenPreview() {
//    val navController = rememberNavController()
//    val viewModel = TaskViewModel()
//    TaskListScreen(navController = navController, viewModel = viewModel)
//}

