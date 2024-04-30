package com.apps.todoapp.domain.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.util.UUID

class Comment() : RealmObject {
    @PrimaryKey
    var commentId : String = ""
    var comment : String = ""
    var commentedBy : String = ""

    constructor(
        commentId : String = UUID.randomUUID().toString(),
        comment : String,
        commentedBy : String
    ) : this() {
        this.comment = comment
        this.commentedBy = commentedBy
        this.commentId = commentId
    }
}