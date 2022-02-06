package com.example.cleanarchitecturenoteapp.presentation.addEdit_screen


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturenoteapp.domain.usecase.NoteUseCases
import com.example.cleanarchitecturenoteapp.domain.usecase.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditScreenViewModel @Inject constructor(
    private val useCases: NoteUseCases
): ViewModel() {

     var titleState = mutableStateOf(NoteTextFieldState())
        private set

     var contentState = mutableStateOf(NoteTextFieldState())
        private set

    fun handleEvent(event:AddEditNoteEvent){
        when(event){

            is AddEditNoteEvent.EnteredTitle -> {

                titleState.value = NoteTextFieldState(
                    text = event.value
                )
            }
            is AddEditNoteEvent.EnteredContent -> {

                contentState.value = NoteTextFieldState(
                    text = event.value
                )

            }
            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    useCases.saveNote(titleState.value.text,contentState.value.text)
                }
            }

        }
    }

    fun getSavedNote(id:Int){
        viewModelScope.launch {
            val entity = useCases.getNote(id)
            titleState.value = NoteTextFieldState(
                text = entity.noteTitle
            )
            contentState.value = NoteTextFieldState(
                text = entity.noteContent
            )
        }
    }
}