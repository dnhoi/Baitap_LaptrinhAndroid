package com.example.bai2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListScreen(navController: NavController) {
    val items = (1..1_000_000).toList()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Blue,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "LazyColumn",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        LazyColumn {
            items(items) { index ->
                ListItem(index, navController)
            }
        }
    }
}

@Composable
fun ListItem(index: Int, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.Blue)
            .clickable { navController.navigate("detail/$index") },
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = "$index | The only way to do great work is to love what you do.",
            modifier = Modifier.weight(1f).padding(8.dp)
        )
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Go to detail",
            modifier = Modifier.padding(8.dp)
        )
    }
}
