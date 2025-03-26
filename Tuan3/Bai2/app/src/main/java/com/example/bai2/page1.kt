package com.example.bai2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun page1(navController: NavHostController)
{
//    LaunchedEffect(Unit) {
//        delay(10000) // Chờ 10 giây
//        navController.navigate("page2")
//    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .clickable { navController.navigate("page2") },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.uth_logo),
            contentDescription = "UTH SmartTasks",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("UTH SmartTasks",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue)
    }
}
