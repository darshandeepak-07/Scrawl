package com.apps.todoapp.domain.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class Thought() : RealmObject {
    @PrimaryKey
    var id : String = ""
    var thought : String = ""
    var createdBy : String = ""
    constructor(
        id : String = UUID.randomUUID().toString(),
        thought : String,
        createdBy : String
    ) : this() {
        this.thought = thought
        this.id = id
        this.createdBy = createdBy
    }
}