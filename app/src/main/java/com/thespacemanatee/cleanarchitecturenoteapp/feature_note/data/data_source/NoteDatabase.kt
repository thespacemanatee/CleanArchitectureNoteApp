package com.thespacemanatee.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thespacemanatee.cleanarchitecturenoteapp.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "notes.db"
    }

    abstract val noteDao: NoteDao
}