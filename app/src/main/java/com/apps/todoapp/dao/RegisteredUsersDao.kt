package com.apps.todoapp.dao

import com.apps.todoapp.domain.model.RegisterdUsers

interface RegisteredUsersDao {
    suspend fun registerUser(user : RegisterdUsers)
    suspend fun getRegisteredUser(username : String) : RegisterdUsers
    suspend fun validateUser(username : String ,password : String) : Boolean
}