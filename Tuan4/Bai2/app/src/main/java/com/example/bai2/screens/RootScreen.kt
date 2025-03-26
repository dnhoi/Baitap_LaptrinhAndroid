package com.example.bai2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bai2.R
import androidx.compose.foundation.shape.RoundedCornerShape as RoundedCornerShape1

@Composable
fun RootScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Navigation",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "is a framework that simplifies the implementation of navigation between different Ul components (activities, fragments, or composables) in an app",
            fontSize = 14.sp ,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f) // Giới hạn độ rộng
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = { navController.navigate("list") },
            shape = RoundedCornerShape(30.dp),
            colors = androidx.compose.material.ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.fillMaxWidth().padding(20.dp).height(50.dp)
        )
        {
            Text(text = "PUSH", fontSize = 18.sp, color = Color.White)
        }
    }
}
