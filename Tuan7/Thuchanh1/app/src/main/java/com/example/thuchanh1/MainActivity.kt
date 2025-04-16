package com.example.thuchanh1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thuchanh1.ui.screen.ThemeSelectorScreen
import com.example.thuchanh1.viewmodel.ThemeViewModel
import com.example.thuchanh1.viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val factory = ViewModelFactory(application)
            val viewModel: ThemeViewModel = viewModel(factory = factory)
            ThemeSelectorScreen(viewModel = viewModel)
        }
    }
}