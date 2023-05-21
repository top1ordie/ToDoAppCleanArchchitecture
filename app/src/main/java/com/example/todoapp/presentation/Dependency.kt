package com.example.todoapp.presentation

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.storage.database.room.AppDatabase

object Dependency {
    private lateinit var _appContext: Context

    fun init(context: Context) {
        _appContext = context
    }

    private val appDataBase: AppDatabase by lazy {
        Room.databaseBuilder(_appContext,AppDatabase::class.java,"database.db").build()
    }
}