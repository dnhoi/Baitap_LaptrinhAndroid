package com.example.bai2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
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
fun page2(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Blue,
                            RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray,
                            RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.LightGray,
                            RoundedCornerShape(50))
                )
            }

            Text(
                text = "Skip",
                fontSize = 16.sp,
                color = Color.Blue,
                modifier = Modifier.clickable { navController.navigate("page4") }
            )
        }

        Spacer(modifier = Modifier.height(150.dp))

        // Main content
        Image(
            painter = painterResource(id = R.drawable.page2),
            contentDescription = "Easy Time Management",
            modifier = Modifier.size(350.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Easy Time Management",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.7f)
        )

        Spacer(modifier = Modifier.weight(1f))

        // Next button
        Button(
            onClick = { navController.navigate("page3") },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Next", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
