package com.example.cleanarchitecturenoteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cleanarchitecturenoteapp.presentation.addEdit_screen.AddEditScreen
import com.example.cleanarchitecturenoteapp.presentation.main_screen.MainScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.AddEditScreen.route + "?uid={uid}",
            arguments = listOf(
                navArgument("uid"){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ){
            AddEditScreen(arg = it.arguments?.getString("uid"), navController = navController)
        }
    }
}