package com.example.bai1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai1.ui.screens.components
import com.example.bai1.ui.screens.componentsDetail
import com.example.bai1.ui.screens.imReady


@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "imReady") {
        composable("imReady") { imReady(navController) }
        composable("components") { components(navController) }
        composable("componentsDetail/{component}") { backStackEntry ->
            val component = backStackEntry.arguments?.getString("component") ?: ""
            componentsDetail(navController, component)
        }
    }
}