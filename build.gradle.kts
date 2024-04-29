
// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("com.google.dagger.hilt.android") version "2.48" apply false
    id("io.realm.kotlin") version "1.11.0" apply false
}
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("io.realm:realm-gradle-plugin:10.3.1")

    }
}