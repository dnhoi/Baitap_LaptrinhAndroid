package com.example.bai2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, itemId: Int) {
    Column(
        modifier = Modifier.fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Arrangement.Center
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Blue,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                "Detail",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "\"The only way to do great work is to love what you do.\"",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(10.dp)
                .height(550.dp)
                .width(300.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = "$itemId \"The only way to do great work is to love what you do.\"",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("root") },
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.fillMaxWidth().padding(20.dp).height(50.dp)
        ) {
            Text(text = "BACK TO ROOT", fontSize = 18.sp, color = Color.White)
        }
    }
}

