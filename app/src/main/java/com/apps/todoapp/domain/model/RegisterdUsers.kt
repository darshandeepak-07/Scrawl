package com.apps.todoapp.domain.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class RegisterdUsers()  : RealmObject{
    @PrimaryKey
    var id : String = ""
    var name : String = ""
    var username : String = ""
    var password : String = ""
    var gender : String = ""
    var age : String = ""
    constructor(
        id : String = UUID.randomUUID().toString(),
        name : String,
        username : String,
        password : String,
        gender : String,
        age : String
    ) : this() {
        this.name = name
        this.id = id
        this.username = username
        this.password = password
        this.gender = gender
        this.age = age
    }
}