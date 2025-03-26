package com.example.bai2


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai2.screens.DetailScreen
import com.example.bai2.screens.ListScreen
import com.example.bai2.screens.RootScreen
import androidx.navigation.navArgument


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "root") {
        composable("root") { RootScreen(navController) }
        composable("list") { ListScreen(navController) }
        composable("detail/{itemId}", arguments = listOf(navArgument("itemId") { type = NavType.IntType })) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
            DetailScreen(navController, itemId)
        }
    }
}
