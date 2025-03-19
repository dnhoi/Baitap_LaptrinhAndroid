package com.example.bai2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun page4(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray, RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray, RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Blue, RoundedCornerShape(50))
                )
            }

            Text(
                text = "Skip",
                fontSize = 16.sp,
                color = Color.Blue,
                modifier = Modifier.clickable { navController.navigate("page1") }
            )
        }

        Spacer(modifier = Modifier.height(150.dp))

        Image(
            painter = painterResource(id = R.drawable.page4),
            contentDescription = "Reminder Notification",
            modifier = Modifier.size(350.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text("Reminder Notification",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Icon(
                Icons.Filled.ArrowBack, // Sử dụng biểu tượng mũi tên quay lại
                contentDescription = "Back",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.navigate("page3") },
                tint = Color.Blue
            )

            Button(
                onClick = { navController.navigate("page1") },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(50.dp)
            ) {
                Text("Get Started", fontSize = 18.sp)
            }
        }
    }
}
