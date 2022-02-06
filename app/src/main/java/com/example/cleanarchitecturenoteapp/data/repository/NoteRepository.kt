package com.example.cleanarchitecturenoteapp.data.repository

import com.example.cleanarchitecturenoteapp.data.local.NoteDao
import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow



class NoteRepository(
    private val dao:NoteDao
) {

    suspend fun saveNote(note:NoteEntity){
        dao.insertNote(note)

    }

    fun getNotes():Flow<List<NoteEntity>> {
        return  dao.getAll()

    }

    suspend fun getNote(id:Int):NoteEntity{
        return dao.getNoteById(id)
    }





}