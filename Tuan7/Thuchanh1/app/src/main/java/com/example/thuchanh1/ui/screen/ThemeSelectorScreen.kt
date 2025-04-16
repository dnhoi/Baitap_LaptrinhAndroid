package com.example.thuchanh1.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thuchanh1.viewmodel.ThemeViewModel

@Composable
fun ThemeSelectorScreen(viewModel: ThemeViewModel) {
    val selected = viewModel.selectedTheme.value
//    val isLoaded = viewModel.isThemeLoaded.value
//
//    if (!isLoaded) {
//        // Loading screen or splash background
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Black),
//            contentAlignment = Alignment.Center
//        ) {
//            Text("Loading...", color = Color.White)
//        }
//        return
//    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(selected.backgroundColor)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Setting",
                color = selected.contentColor,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Choosing the right theme sets the tone and personality of your app",
                color = selected.contentColor.copy(alpha = 0.8f),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                viewModel.themes.forEach { theme ->
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(theme.primaryColor)
                            .clickable { viewModel.selectedTheme.value = theme }
                            .border(
                                width = if (theme == selected) 3.dp else 1.dp,
                                color = if (theme == selected) Color.Blue else Color.Gray,
                                shape = CircleShape
                            )
                    )
                }
            }
        }
        Button(
            onClick = { viewModel.saveTheme() }, // Lưu lại theme được chọn
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Apply")
        }
    }
}
