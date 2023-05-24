package com.example.todoapp.data.storage

import com.example.todoapp.data.storage.database.room.entities.TaskRoom
import com.example.todoapp.data.storage.model.Task

interface TaskStorage {
    suspend fun getAllTasks(): List<Task>
    suspend fun saveTask(task: TaskRoom)
    suspend fun deleteTask(task: TaskRoom)
}