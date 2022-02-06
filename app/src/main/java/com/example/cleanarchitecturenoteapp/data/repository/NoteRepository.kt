package com.example.cleanarchitecturenoteapp.data.repository

import com.example.cleanarchitecturenoteapp.data.local.NoteDao
import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import com.example.cleanarchitecturenoteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow



class NoteRepositoryImpl(
    private val dao:NoteDao
):NoteRepository {

    override suspend fun saveNote(note:NoteEntity){
        dao.insertNote(note)

    }

    override fun getNotes():Flow<List<NoteEntity>> {
        return  dao.getAll()

    }

    override suspend fun getNote(id:Int):NoteEntity{
        return dao.getNoteById(id)
    }





}