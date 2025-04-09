package com.example.bai1.model

import androidx.compose.ui.graphics.Color
import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val color: Color
)
