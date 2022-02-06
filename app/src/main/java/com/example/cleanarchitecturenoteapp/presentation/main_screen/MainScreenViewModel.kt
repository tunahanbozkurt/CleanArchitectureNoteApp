package com.example.cleanarchitecturenoteapp.presentation.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import com.example.cleanarchitecturenoteapp.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCases: NoteUseCases
):ViewModel() {

    private var job:Job? = null

    var notesState = mutableStateOf(emptyList<NoteEntity>())
        private set
    
    init {

        getNotes()

    }


    private fun getNotes(){
        job?.cancel()

        job = useCases.getNotes().onEach {
            notesState.value = it

        }.launchIn(viewModelScope)

    }



}