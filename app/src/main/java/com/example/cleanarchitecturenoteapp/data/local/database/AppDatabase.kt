package com.example.cleanarchitecturenoteapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecturenoteapp.data.local.NoteDao
import com.example.cleanarchitecturenoteapp.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract val noteDao: NoteDao
}