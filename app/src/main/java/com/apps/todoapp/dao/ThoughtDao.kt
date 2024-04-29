package com.apps.todoapp.dao

import com.apps.todoapp.domain.model.Thought

interface ThoughtDao {
    suspend fun createThought(thought : Thought)
    suspend fun getThoughts() : List<Thought>
}