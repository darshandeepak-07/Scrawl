package com.apps.todoapp.presentation.screens.dashboard.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.todoapp.domain.model.Thought
import com.apps.todoapp.domain.usecase.AddThoughtUseCase
import kotlinx.coroutines.launch

class HomeScreenViewModel (
    addThoughtUseCase: AddThoughtUseCase = AddThoughtUseCase()
) : ViewModel(){
    private val _addThoughtUseCase = addThoughtUseCase
    val thoughts : MutableLiveData<List<Thought>> = MutableLiveData(null)

    fun addThought(thought : Thought) {
        viewModelScope.launch {
            _addThoughtUseCase.createThought(thought)
        }
    }

    fun getThoughts() {
        viewModelScope.launch {
            thoughts.value = _addThoughtUseCase.getThoughts()
        }
    }
}