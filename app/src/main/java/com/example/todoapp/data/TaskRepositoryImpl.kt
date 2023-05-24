package com.example.todoapp.data

import com.example.todoapp.data.storage.TaskStorage
import com.example.todoapp.data.storage.database.room.entities.TaskRoom
import com.example.todoapp.data.storage.model.Task
import com.example.todoapp.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskStorage: TaskStorage) : TaskRepository {
    override suspend fun getAllTasks(): List<com.example.todoapp.domain.model.Task> {
        return mapToDomain(taskStorage.getAllTasks())
    }

    override suspend fun removeTask(task: com.example.todoapp.domain.model.Task) {
        taskStorage.deleteTask(mapToRoomTask(task))
    }

    override suspend fun saveTask(task: com.example.todoapp.domain.model.Task) {
        val taskData =
            Task(id = task.id, name = task.name, date = task.date, isCompleted = task.isCompleted)
        taskStorage.saveTask(mapToRoom(taskData))
    }


    fun mapToRoom(task: Task): TaskRoom {
        val taskRoom = TaskRoom(
            id = task.id,
            name = task.name,
            date = task.date,
            isCompleted = task.isCompleted
        )
        return taskRoom
    }

    fun mapToDomain(task: List<Task>): List<com.example.todoapp.domain.model.Task> {
        val result = mutableListOf<com.example.todoapp.domain.model.Task>()
        for (i in task) {
            result.add(
                com.example.todoapp.domain.model.Task(
                    id = i.id,
                    name = i.name,
                    date = i.date,
                    isCompleted = i.isCompleted
                )
            )
        }
        return result
    }

    fun mapToRoomTask(task: com.example.todoapp.domain.model.Task): TaskRoom {
        return TaskRoom(task.id,task.name,task.date,task.isCompleted)
    }

}