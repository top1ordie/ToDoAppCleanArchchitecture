package com.example.todoapp.data

import com.example.todoapp.data.storage.TaskStorage
import com.example.todoapp.data.storage.model.Task
import com.example.todoapp.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskStorage: TaskStorage): TaskRepository {
    override fun getAllTasks(): List<com.example.todoapp.domain.model.Task> {
        return mapToDomain(taskStorage.getAllTasks())
    }

    override fun removeTask() {
        TODO("Not yet implemented")
    }

    override fun saveTask() {
        TODO("Not yet implemented")
    }

    fun mapToDomain(task: List<Task>): List<com.example.todoapp.domain.model.Task> {
        val result = mutableListOf<com.example.todoapp.domain.model.Task>()
        for (i in task) {
            result.add(com.example.todoapp.domain.model.Task(i.name,i.date,i.isCompleted))
        }
        return result
    }

}