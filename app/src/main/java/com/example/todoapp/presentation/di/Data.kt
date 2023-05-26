package com.example.todoapp.presentation.di

import androidx.room.Room
import com.example.todoapp.data.TaskRepositoryImpl
import com.example.todoapp.data.storage.TaskStorage
import com.example.todoapp.data.storage.database.TaskStorageDataBaseImp
import com.example.todoapp.data.storage.database.room.AppDatabase
import com.example.todoapp.data.storage.database.room.TaskDao
import com.example.todoapp.domain.repository.TaskRepository
import org.koin.dsl.module

val dataModule = module {
    single<TaskDao> {
        Room.databaseBuilder(get(), AppDatabase::class.java, "task.db").build().dao
    }
    single<TaskStorage>{
        TaskStorageDataBaseImp(get())
    }
    single<TaskRepository> {
        TaskRepositoryImpl(get())
    }
}