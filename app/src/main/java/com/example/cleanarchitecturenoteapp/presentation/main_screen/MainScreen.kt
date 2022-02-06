package com.example.cleanarchitecturenoteapp.presentation.main_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturenoteapp.R
import com.example.cleanarchitecturenoteapp.navigation.Screen
import com.example.cleanarchitecturenoteapp.presentation.main_screen.components.ListItem

@Composable
fun MainScreen(
    navController: NavController,
    viewModel:MainScreenViewModel = hiltViewModel()

) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.AddEditScreen.route) },
            backgroundColor = Color.Magenta,
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_add_24),
                    contentDescription = "add",
                    tint = Color.White
                )
            })


        }
    ) {

        LazyColumn(){
            items(items = viewModel.notesState.value){ noteEntity ->

                ListItem(entity = noteEntity){
                    navController.navigate(Screen.AddEditScreen.route + "?uid=$it")
                }

                
            }

        }

    }
}

