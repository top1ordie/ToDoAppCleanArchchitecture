package com.example.todoapp.presentation.di

import com.example.todoapp.domain.GetAllTasks
import com.example.todoapp.domain.RemoveTask
import com.example.todoapp.domain.SaveTask
import org.koin.dsl.module

val domainModule = module {
    single {
        GetAllTasks(get())
    }
    single {
        RemoveTask(get())
    }
    single {
        SaveTask(get())
    }
}