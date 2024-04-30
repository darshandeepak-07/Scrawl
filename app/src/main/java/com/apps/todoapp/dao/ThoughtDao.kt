package com.apps.todoapp.dao

import com.apps.todoapp.domain.model.Comment
import com.apps.todoapp.domain.model.Thought

interface ThoughtDao {
    suspend fun createThought(thought : Thought)
    suspend fun getThoughts() : List<Thought>
    suspend fun writeComment(id:String ,comment: Comment)  : Boolean
    suspend fun getComments(thoughtId : String) : List<Comment>
}