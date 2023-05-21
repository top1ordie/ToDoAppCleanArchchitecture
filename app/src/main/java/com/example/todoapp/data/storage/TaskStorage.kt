package com.example.todoapp.data.storage

import com.example.todoapp.data.storage.model.Task

interface TaskStorage {
    fun getAllTasks(): List<Task>
    fun saveTask()
    fun deleteTask()
}