package com.apps.todoapp.dao

import android.util.Log
import com.apps.todoapp.BaseApplcation.Companion.realm
import com.apps.todoapp.domain.model.Comment
import com.apps.todoapp.domain.model.Thought
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.find
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

open class ThoughtDaoImpl :  ThoughtDao {
    override suspend fun createThought(thought: Thought) {
        realm.write {
            copyToRealm(thought)
        }
    }

    override suspend fun getThoughts(): List<Thought> {
        return realm.query(Thought::class).find()
    }

//    override suspend fun writeComment(id: String,comment: Comment) : Boolean{
//        var written = false
//        realm.query(Thought::class).find {
//            it.forEach { value->
//                if(value.id == id){
//                    value.comment?.add(comment)
//                    Log.e("TAG", "writeComment: success from impl", )
//                    written = true
//                }
//            }
//        }
//        if(written){
//            Log.e("TAG", "writeComment: success", )
//        }else{
//            Log.e("TAG", "writeComment: failed", )
//        }
//        return written
//    }
override suspend fun writeComment(thoughtId: String, comment: Comment): Boolean {
    var written = false
    realm.write {
        val thoughts = query<Thought>("id == $0",thoughtId).find().first()
        thoughts.comment?.add(comment)
        written = true
    }
    if (written) {
        Log.e("TAG", "writeComment: success")
    } else {
        Log.e("TAG", "writeComment: failed")
    }
    return written
}


    override suspend fun getComments(thoughtId: String): List<Comment> {
        var comments : List<Comment> = mutableListOf()
         realm.query(Thought::class).find {
            it.forEach { value->
                if(value.id == thoughtId) comments = value.comment ?: listOf()
            }
        }
        Log.e("TAG", "getComments: ${comments.size}", )
        return comments
    }
}