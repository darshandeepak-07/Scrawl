package com.apps.todoapp.presentation.screens.addnote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.todoapp.model.Note
import com.apps.todoapp.presentation.screens.usecase.AddNoteUseCase
import kotlinx.coroutines.launch


class AddNoteViewModel (
    addNoteUseCase: AddNoteUseCase = AddNoteUseCase()
): ViewModel() {
    private val _addNoteUseCase = addNoteUseCase
    val notes : MutableLiveData<List<Note>> = MutableLiveData(null)
     fun addNote(note : Note) {
         viewModelScope.launch {
             _addNoteUseCase.createNote(note)
             Log.e("TAG", "addNote: Note Added", )
         }
    }

    fun getNotes()  {
        viewModelScope.launch {
            notes.value = _addNoteUseCase.getNotes()
        }
    }
}