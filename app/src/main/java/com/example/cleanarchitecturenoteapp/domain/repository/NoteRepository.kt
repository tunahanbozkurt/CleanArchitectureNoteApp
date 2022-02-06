package com.example.cleanarchitecturenoteapp.domain.repository

import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {


    suspend fun saveNote(note: NoteEntity)

    fun getNotes(): Flow<List<NoteEntity>>

    suspend fun getNote(id:Int): NoteEntity
}