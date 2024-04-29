package com.apps.todoapp.presentation.screens

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.todoapp.domain.model.RegisterdUsers
import com.apps.todoapp.domain.usecase.RegisterUserUseCase
import kotlinx.coroutines.launch

class MainViewModel (
    registerUserUseCase: RegisterUserUseCase = RegisterUserUseCase()
) : ViewModel(){
    private var _registerUserUseCase = registerUserUseCase
    var isValidated : MutableLiveData<Boolean> = MutableLiveData(false)
    val user : MutableLiveData<RegisterdUsers> = MutableLiveData(RegisterdUsers())
    fun registerUser(user: RegisterdUsers){
        viewModelScope.launch {
            _registerUserUseCase.registerUser(user)
            Log.e("TAG", "registerUser: successfull", )
        }
    }

    fun getRegisteredUser(username:String) {
        viewModelScope.launch {
           user.value =  _registerUserUseCase.getRegisteredUser(username)
        }
    }

    fun validateUser(username: String,password:String){
        viewModelScope.launch {
           isValidated.value =  _registerUserUseCase.validateUser(username,password)
        }
    }
}