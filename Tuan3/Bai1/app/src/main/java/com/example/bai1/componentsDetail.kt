package com.example.bai1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun componentsDetail(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    .size(20.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                "Text Detail",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            buildAnnotatedString {
                append("The ")
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("quick ")
                }
                withStyle(style = SpanStyle(color = Color(0xFFFF9800), fontWeight = FontWeight.Bold)) {
                    append("Brown ")
                }
                append("fox ")
                withStyle(style = SpanStyle(letterSpacing = 5.sp)) {
                    append("jumps ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("over ")
                }
                withStyle(style = SpanStyle(fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)) {
                    append("the lazy ")
                }
                append("dog.")
            },
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}
