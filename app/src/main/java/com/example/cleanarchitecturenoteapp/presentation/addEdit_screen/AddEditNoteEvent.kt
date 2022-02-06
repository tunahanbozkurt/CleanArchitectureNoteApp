package com.example.cleanarchitecturenoteapp.presentation.addEdit_screen

import androidx.compose.ui.focus.FocusState

sealed class AddEditNoteEvent{
    data class EnteredTitle(val value: String): AddEditNoteEvent()
    data class EnteredContent(val value: String): AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}