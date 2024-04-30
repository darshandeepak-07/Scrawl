package com.apps.todoapp;

import android.app.Application
import android.content.Context
import com.apps.todoapp.domain.model.Comment
import com.apps.todoapp.domain.model.RegisterdUsers
import com.apps.todoapp.domain.model.Thought
import com.apps.todoapp.model.Note
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.migration.RealmMigration
import javax.inject.Singleton


@HiltAndroidApp
class BaseApplcation : Application() {

    companion object {
        lateinit var realm : Realm
    }
    override fun onCreate() {
        realm = RealmModule.provideRealmDB(applicationContext)
        super.onCreate()
    }

    @InstallIn(SingletonComponent::class)
    @Module
    object RealmModule {
    @Provides
    @Singleton
    fun provideRealmDB(
        @ApplicationContext context: Context
    ) : Realm{

        val realmConfig = RealmConfiguration.Builder(
            schema = setOf(
                Note::class,
                Thought::class,
                RegisterdUsers::class,
                Comment::class
            )
        ).schemaVersion(3).build()
        return Realm.open(realmConfig)
    }
    }
}
