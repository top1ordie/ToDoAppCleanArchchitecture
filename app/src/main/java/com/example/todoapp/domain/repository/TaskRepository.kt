package com.example.todoapp.domain.repository

import com.example.todoapp.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun getAllTasks(): List<Task>

    suspend fun removeTask(task: Task)

    suspend fun saveTask(task: Task)
}