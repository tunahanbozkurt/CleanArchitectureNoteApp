package com.example.cleanarchitecturenoteapp.data.local

import androidx.room.*
import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteEntity")
    fun getAll(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM noteEntity WHERE uid = :id")
    suspend fun getNoteById(id:Int):NoteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note:NoteEntity)



}