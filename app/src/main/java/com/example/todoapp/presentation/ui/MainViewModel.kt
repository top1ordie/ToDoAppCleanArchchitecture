package com.example.todoapp.presentation.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.todoapp.data.TaskRepositoryImpl
import com.example.todoapp.data.storage.database.TaskStorageDataBaseImp
import com.example.todoapp.data.storage.database.room.AppDatabase
import com.example.todoapp.domain.GetAllTasks
import com.example.todoapp.domain.RemoveTask
import com.example.todoapp.domain.SaveTask

class MainViewModel(val context: Context): ViewModel() {

    val dao =
        Room.databaseBuilder(context, AppDatabase::class.java, "task.db").build().dao
    val taskStorage = TaskStorageDataBaseImp(dao)
    val taskRepository = TaskRepositoryImpl(taskStorage)
    val getAllTasks = GetAllTasks(taskRepository)
    val removeTask = RemoveTask(taskRepository)
    val saveTask = SaveTask(taskRepository)

}