package com.apps.todoapp.dao

import com.apps.todoapp.BaseApplcation.Companion.realm
import com.apps.todoapp.domain.model.RegisterdUsers
import io.realm.kotlin.query.find

open class RegisteredUsersImpl : RegisteredUsersDao {
    override suspend fun registerUser(user: RegisterdUsers) {
        realm.write {
            copyToRealm(user)
        }
    }

    override suspend fun getRegisteredUser(username: String): RegisterdUsers {
        return realm.query(RegisterdUsers::class).find {
            it.find { value ->
                value.username == username
            } ?: RegisterdUsers()
        }
    }

    override suspend fun validateUser(username: String, password: String): Boolean {
        var userExist = false
        realm.query(RegisterdUsers::class).find {
            it.forEach { value ->
                if (value.username.equals(username) && value.password.equals(password))
                    userExist = true
            }
        }
        return userExist

    }
}