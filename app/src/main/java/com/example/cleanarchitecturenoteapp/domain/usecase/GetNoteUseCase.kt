package com.example.cleanarchitecturenoteapp.domain.usecase

import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import com.example.cleanarchitecturenoteapp.data.repository.NoteRepository

class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id:Int):NoteEntity{
        return repository.getNote(id = id)
    }


}