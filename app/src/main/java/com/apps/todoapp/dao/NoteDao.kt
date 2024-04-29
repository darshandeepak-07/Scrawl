package com.apps.todoapp.dao

import com.apps.todoapp.model.Note

interface NoteDao {
    suspend fun createNote(note : Note)
    suspend fun getNotes() : List<Note>
}