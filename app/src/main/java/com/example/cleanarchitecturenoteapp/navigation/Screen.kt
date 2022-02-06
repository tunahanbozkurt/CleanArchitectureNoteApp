package com.example.cleanarchitecturenoteapp.navigation

sealed class Screen(val route:String){
    object MainScreen: Screen("main_screen")
    object AddEditScreen: Screen("add-edit_screen")

    }







