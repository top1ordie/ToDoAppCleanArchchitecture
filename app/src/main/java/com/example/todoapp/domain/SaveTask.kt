package com.example.todoapp.domain

import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.repository.TaskRepository

class SaveTask(private val taskRepository: TaskRepository) {
    suspend fun execute(task: Task) {
        taskRepository.saveTask(task)
    }
}