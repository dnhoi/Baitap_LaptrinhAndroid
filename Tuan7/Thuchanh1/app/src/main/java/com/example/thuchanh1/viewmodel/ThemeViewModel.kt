package com.example.thuchanh1.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.thuchanh1.datastore.ThemePreferenceManager
import com.example.thuchanh1.model.ThemeOption
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color

class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext

    val themes = listOf(
        ThemeOption("Light", Color.White, Color.White, Color.Black),
        ThemeOption("Dark", Color.Black, Color.Black, Color.White),
        ThemeOption("Pink", Color(0xFFE91E63), Color(0xFFE91E63), Color.White),
        ThemeOption("Blue", Color(0xFF90CAF9), Color(0xFF90CAF9), Color.Black)
    )

    val selectedTheme = mutableStateOf(themes[0])
    val isThemeLoaded = mutableStateOf(false)
    init {
        ThemePreferenceManager.getSavedTheme(context)
            .onEach { savedName ->
                selectedTheme.value = themes.find { it.name == savedName } ?: themes[0]
            }
            .launchIn(viewModelScope)
    }

    fun saveTheme() {
        viewModelScope.launch {
            ThemePreferenceManager.saveTheme(context, selectedTheme.value.name)
        }
    }
}
