package com.example.todoapp.domain.repository

import com.example.todoapp.domain.model.Task

interface TaskRepository {
    fun getAllTasks() : List<Task>

    fun removeTask()

    fun saveTask()
}