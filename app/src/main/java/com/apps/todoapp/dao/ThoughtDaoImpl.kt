package com.apps.todoapp.dao

import com.apps.todoapp.BaseApplcation.Companion.realm
import com.apps.todoapp.domain.model.Thought

open class ThoughtDaoImpl :  ThoughtDao {
    override suspend fun createThought(thought: Thought) {
        realm.write {
            copyToRealm(thought)
        }
    }

    override suspend fun getThoughts(): List<Thought> {
        return realm.query(Thought::class).find()
    }
}