package com.example.todoapp.domain

import com.example.todoapp.domain.model.Task
import com.example.todoapp.domain.repository.TaskRepository

class RemoveTask(private val taskRepository: TaskRepository) {
     suspend fun execute(task: Task) {
        taskRepository.removeTask(task)
    }
}