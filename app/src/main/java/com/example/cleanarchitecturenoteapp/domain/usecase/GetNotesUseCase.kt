package com.example.cleanarchitecturenoteapp.domain.usecase

import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import com.example.cleanarchitecturenoteapp.data.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(
    private val repository: NoteRepository
) {

     operator fun invoke(): Flow<List<NoteEntity>> {
         return repository.getNotes()

    }
}