package com.example.todoapp.domain

import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.repository.TaskRepository

class GetAllTasks(private val taskRepository: TaskRepository) {
    suspend fun execute(): List<Task> {
        return taskRepository.getAllTasks()
    }
}