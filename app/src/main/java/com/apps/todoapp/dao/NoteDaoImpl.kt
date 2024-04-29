package com.apps.todoapp.dao

import com.apps.todoapp.BaseApplcation.Companion.realm
import com.apps.todoapp.model.Note

open class NoteDaoImpl : NoteDao{

    override suspend fun createNote(note: Note) {
        realm.write {
            copyToRealm(note)
        }
    }

    override suspend fun getNotes() : List<Note>{
        return realm.query(Note::class).find()
    }

}