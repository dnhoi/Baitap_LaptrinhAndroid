package com.example.bai3.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.bai3.R

@Composable
fun TopBar(title: String, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Icon back
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back Icon",
            modifier = Modifier
                .padding(start = 8.dp)
                .size(48.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        // Tiêu đề ở giữa với kích thước chữ tùy chỉnh
        Text(
            text = title,
            color = Color.Blue,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

        // Không gian bên phải
        //Spacer(modifier = Modifier.width(48.dp))
        Image(
            painterResource(R.drawable.image15),
            contentDescription = null,
            Modifier.size(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    Bai3Theme {
        TopBar(title = "Detail", navController = rememberNavController())
    }
}