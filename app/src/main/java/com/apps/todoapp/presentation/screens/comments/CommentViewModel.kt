package com.apps.todoapp.presentation.screens.comments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.todoapp.domain.model.Comment
import com.apps.todoapp.domain.usecase.AddThoughtUseCase
import kotlinx.coroutines.launch

class CommentViewModel(
    addThoughtUseCase: AddThoughtUseCase = AddThoughtUseCase()
) : ViewModel() {
    val _addThoughtUseCase = addThoughtUseCase
    val comments : MutableLiveData<List<Comment>> = MutableLiveData(mutableListOf())

    fun writeComment(thoughtId : String , comment: Comment){
        viewModelScope.launch {
            _addThoughtUseCase.writeComment(thoughtId = thoughtId,comment = comment)
            Log.e("TAG", "writeComment: success", )
        }
    }

    fun getComments(thoughtId : String) {
        viewModelScope.launch {
           comments.value =  _addThoughtUseCase.getComments(thoughtId)
            Log.e("TAG", "getComments: ${comments.value!!.size}", )
        }
    }


}