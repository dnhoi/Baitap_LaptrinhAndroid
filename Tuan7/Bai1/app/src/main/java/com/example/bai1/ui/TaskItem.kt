package com.example.bai1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bai1.model.Task

@Composable
fun TaskItem(task: Task) {
    Card(
        modifier = Modifier.fillMaxWidth().height(80.dp),
        //backgroundColor = Color(task.color),
        backgroundColor = task.color,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(task.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(task.description, fontSize = 14.sp)
        }
    }
}
