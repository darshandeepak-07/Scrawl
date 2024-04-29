package com.apps.todoapp.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class Note() : RealmObject {
    @PrimaryKey
    var id : String = ""
    var title : String = ""
    var description : String = ""

    constructor(
        id : String = UUID.randomUUID().toString(),
        title : String,
        description : String
    ) : this() {
        this.title = title
        this.description = description
        this.id = id
    }
}