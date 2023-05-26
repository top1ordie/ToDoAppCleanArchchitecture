package com.example.todoapp.presentation.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.todoapp.data.TaskRepositoryImpl
import com.example.todoapp.data.storage.TaskStorage
import com.example.todoapp.data.storage.database.TaskStorageDataBaseImp
import com.example.todoapp.data.storage.database.room.AppDatabase
import com.example.todoapp.data.storage.database.room.TaskDao
import com.example.todoapp.domain.GetAllTasks
import com.example.todoapp.domain.RemoveTask
import com.example.todoapp.domain.SaveTask
import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.repository.TaskRepository
import kotlinx.coroutines.launch

class MainViewModel(
    val dao: TaskDao,
    val taskStorage: TaskStorage,
    val taskRepository: TaskRepository,
    val getAllTasks: GetAllTasks,
    val removeTask: RemoveTask,
    val saveTask: SaveTask
) : ViewModel() {
    val _list = MutableLiveData<List<Task>>()

    fun someShit() {
        viewModelScope.launch {
            _list.value = getAllTasks.execute()
        }
    }


}