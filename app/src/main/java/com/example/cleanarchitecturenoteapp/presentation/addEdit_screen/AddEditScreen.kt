package com.example.cleanarchitecturenoteapp.presentation.addEdit_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cleanarchitecturenoteapp.R
import com.example.cleanarchitecturenoteapp.navigation.Screen


@Composable
fun AddEditScreen(
    viewModel:AddEditScreenViewModel = hiltViewModel(),
    arg:String?,
    navController: NavController

) {
    if(!arg.isNullOrEmpty()){
        viewModel.getSavedNote(arg.toInt())

    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {

            viewModel.handleEvent(AddEditNoteEvent.SaveNote)
            navController.navigate(Screen.MainScreen.route)
                                       },
            backgroundColor = Color.Magenta,
            content = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_check_24),
                    contentDescription = "add",
                    tint = Color.White
                )
            })

    }) {
        Column(
            Modifier.fillMaxSize()

        ) {

            OutlinedTextField(
                value = viewModel.titleState.value.text,
                onValueChange = { viewModel.handleEvent(AddEditNoteEvent.EnteredTitle(it)) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.contentState.value.text,
                onValueChange = { viewModel.handleEvent(AddEditNoteEvent.EnteredContent(it)) },
                modifier = Modifier
                    .weight(10f)
                    .fillMaxWidth()
            )
        }

    }
}









