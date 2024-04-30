package com.apps.todoapp.domain.model

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

import io.realm.kotlin.types.RealmList
import java.util.*

open class Thought() : RealmObject {
    @PrimaryKey
    var id : String = ""
    var thought : String = ""
    var createdBy : String = ""
    var comment : RealmList<Comment>? = realmListOf()

    constructor(
        id : String = UUID.randomUUID().toString(),
        thought : String,
        createdBy : String,
        comment: Comment?
    ) : this() {
        this.thought = thought
        this.id = id
        this.createdBy = createdBy
        if (comment != null) {
            this.comment?.add(comment)
        }
    }
}


//class Thought() : RealmObject {
//    @PrimaryKey
//    var id : String = ""
//    var thought : String = ""
//    var createdBy : String = ""
//    var comment : List<Comment>? = listOf()
//    constructor(
//        id : String = UUID.randomUUID().toString(),
//        thought : String,
//        createdBy : String,
//        comment: Comment?
//    ) : this() {
//        this.thought = thought
//        this.id = id
//        this.createdBy = createdBy
//        if (comment != null) {
//            this.comment = this.comment?.plus(comment)
//        }
//    }
//}