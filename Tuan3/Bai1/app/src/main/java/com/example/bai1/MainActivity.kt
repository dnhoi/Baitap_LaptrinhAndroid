package com.example.bai1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai1.navigation.AppNavigator
import com.example.bai1.ui.screens.components
import com.example.bai1.ui.screens.componentsDetail
import com.example.bai1.ui.screens.imReady

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}



