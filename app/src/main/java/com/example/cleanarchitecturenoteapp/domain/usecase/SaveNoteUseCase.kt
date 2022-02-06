package com.example.cleanarchitecturenoteapp.domain.usecase

import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import com.example.cleanarchitecturenoteapp.data.repository.NoteRepository

class SaveNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(title:String?, content:String?){
        if (title != null && content != null){
            repository.saveNote(
                NoteEntity(
                    noteTitle = title,
                    noteContent = content
                )
            )
        }
    }


}