package com.example.cleanarchitecturenoteapp.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity


@Composable
fun ListItem(entity:NoteEntity,onclick:(Int) -> Unit){
    Row() {

        Column(modifier = Modifier.background(Color.Yellow).border(3.dp,Color.Gray).clickable {
            onclick(entity.uid)
        }) {
            Text(text = entity.noteTitle, modifier = Modifier.padding(10.dp).fillMaxWidth())
            Text(text = entity.noteContent,modifier = Modifier.padding(10.dp).fillMaxWidth())
        }
    }
}


