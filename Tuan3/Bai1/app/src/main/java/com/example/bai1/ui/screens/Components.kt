package com.example.bai1.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun components(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF2196F3),
                modifier = Modifier
                    .size(22.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                "UI Components List",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(5.dp)
        ) {
            Text(
                "Display",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            ComponentItem(
                "Text",
                "Displays text"
            )
            { navController.navigate("componentsDetail/Text") }
            ComponentItem(
                "Image",
                "Displays an image"
            )
            { navController.navigate("componentsDetail/Image") }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Input",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            ComponentItem(
                "TextField",
                "Input field for text"
            )
            { navController.navigate("componentsDetail/TextField") }
            ComponentItem(
                "PasswordField",
                "Input field for passwords"
            )
            { navController.navigate("componentsDetail/PasswordField") }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Layout",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            ComponentItem(
                "Column",
                "Arranges elements vertically"
            )
            { navController.navigate("componentsDetail/Column") }
            ComponentItem(
                "Row",
                "Arranges elements horizontally"
            )
            { navController.navigate("componentsDetail/Row") }
            ComponentItem(
                "LazyColumn",
                "Arranges elements vertically"
            )
            { navController.navigate("componentsDetail/LazyColumn") }
            ComponentItem(
                "LazyRow",
                "Arranges elements horizontally"
            )
            { navController.navigate("componentsDetail/LazyRow") }
            ComponentItem(
                "Box",
                "Arranges elements horizontally"
            )
            { navController.navigate("componentsDetail/Box") }
        }
    }
}
@Composable
fun ComponentItem(title: String, description: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE))
    ) {
        Column(modifier = Modifier.padding(16.dp))
        {
            Text(title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
            Text(description,
                fontSize = 14.sp)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewComponents() {
    components(navController = rememberNavController())
}


