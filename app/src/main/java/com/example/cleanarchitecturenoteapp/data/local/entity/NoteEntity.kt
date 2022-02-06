package com.example.cleanarchitecturenoteapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteEntity")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0 ,
    @ColumnInfo(name = "note_title") val noteTitle: String,
    @ColumnInfo(name = "note_content") val noteContent: String,
)




