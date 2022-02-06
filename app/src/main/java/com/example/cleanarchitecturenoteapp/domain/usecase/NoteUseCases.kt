package com.example.cleanarchitecturenoteapp.domain.usecase

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val saveNote: SaveNoteUseCase,
    val getNote: GetNoteUseCase
)
