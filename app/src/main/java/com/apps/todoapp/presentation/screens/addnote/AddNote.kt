package com.apps.todoapp.presentation.screens.addnote

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.apps.todoapp.model.Note

@Composable
fun AddNote(
    paddingValues: PaddingValues,
    viewModel: AddNoteViewModel = AddNoteViewModel(),
) {
    viewModel.addNote(Note(title = "Deepak", description = "This is a sample Note"))

    viewModel.getNotes()
    viewModel.notes.value?.forEach {
        Log.e("TAG", "AddNote: ${it.title}", )
    }
}