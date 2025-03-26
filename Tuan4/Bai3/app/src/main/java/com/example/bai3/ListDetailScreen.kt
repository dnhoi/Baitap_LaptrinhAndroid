package com.example.bai3

import android.graphics.Color.rgb
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bai3.ui.theme.Bai3Theme // Đã sửa import
import com.example.bai3.ui.theme.TopBar // Đảm bảo thư mục theme có file TopBar

@Composable
fun DetailScreen(taskId: Int, navController: NavController, viewModel: TaskViewModel = viewModel()) {
    val uiState = viewModel.uiState.collectAsState().value

    LaunchedEffect(Unit) {
        if (uiState.tasks.isEmpty() && !uiState.isLoading) {
            viewModel.fetchTasks()
        }
    }

    LaunchedEffect(uiState.tasks) {
        if (uiState.tasks.isNotEmpty()) {
            viewModel.selectTask(taskId)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar("Detail", navController)

        uiState.selectedTask?.let { task ->
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    Text(
                        text = task.title,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = task.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                item {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color(0xFFFFE5E5), RoundedCornerShape(8.dp))
//                            .padding(12.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text("Category\nWork", fontSize = 14.sp)
//                        Text("Status\nIn Progress", fontSize = 14.sp)
//                        Text("Priority\nHigh", fontSize = 14.sp)
//                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color(rgb(225, 187, 193)),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        //Column1
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painterResource(R.drawable.image8),
                                    contentDescription = null,
                                    Modifier.size(28.dp)
                                )
                                Column(
                                    Modifier.padding(start = 5.dp)
                                ) {
                                    Text("Category", fontSize = 14.sp)
                                    Text("${task?.category}", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                                }
                            }
                        }
                        Spacer(Modifier.width(5.dp))

                        //Column2
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painterResource(R.drawable.image9),
                                    contentDescription = null,
                                    Modifier.size(28.dp)
                                )
                                Column(
                                    Modifier.padding(start = 5.dp)
                                ) {
                                    Text("Status", fontSize = 14.sp)
                                    Text("${task?.status}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                        Spacer(Modifier.width(5.dp))

                        //Column3
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painterResource(R.drawable.image10),
                                    contentDescription = null,
                                    Modifier.size(28.dp)
                                )
                                Column(
                                    Modifier.padding(start = 5.dp)
                                ) {
                                    Text("Priority", fontSize = 14.sp)
                                    Text("${task?.priority}", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }

                item {
                    Text(
                        text = "Subtasks",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                    task.subtasks?.forEach { subtask ->
                        var checked by remember { mutableStateOf(false) }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                                .background(Color.LightGray, RoundedCornerShape(8.dp))
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(checked = checked, onCheckedChange = { checked = it })
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(subtask.title)
                        }
                    } ?: Text("No subtasks available")
                }

                item {
                    Text(
                        text = "Attachments",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                    task.attachments?.forEach { attachment ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                                .background(Color.Gray, RoundedCornerShape(8.dp))
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.dcm),
                                contentDescription = "File Icon",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(attachment.fileName, color = Color.White)
                        }
                    } ?: Text("No attachments available")
                }
            }
        } ?: Text("Task not found", textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Bai3Theme {
        DetailScreen(taskId = 1, navController = rememberNavController())
    }
}
