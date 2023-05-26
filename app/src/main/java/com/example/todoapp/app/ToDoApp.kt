package com.example.todoapp.app

import android.app.Application
import com.example.todoapp.presentation.di.dataModule
import com.example.todoapp.presentation.di.domainModule
import com.example.todoapp.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ToDoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ToDoApp)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}