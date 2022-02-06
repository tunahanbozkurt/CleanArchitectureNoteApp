package com.example.cleanarchitecturenoteapp.di

import android.content.Context
import androidx.room.Room

import com.example.cleanarchitecturenoteapp.data.local.database.AppDatabase
import com.example.cleanarchitecturenoteapp.data.repository.NoteRepository
import com.example.cleanarchitecturenoteapp.domain.usecase.GetNoteUseCase
import com.example.cleanarchitecturenoteapp.domain.usecase.GetNotesUseCase
import com.example.cleanarchitecturenoteapp.domain.usecase.NoteUseCases
import com.example.cleanarchitecturenoteapp.domain.usecase.SaveNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext:Context): AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,"note-database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db:AppDatabase):NoteRepository{
        return NoteRepository(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository:NoteRepository):NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository = repository),
            saveNote = SaveNoteUseCase(repository = repository),
            getNote = GetNoteUseCase(repository = repository)
        )
    }


}
