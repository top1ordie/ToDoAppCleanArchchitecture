package com.example.todoapp.data.storage.database

import com.example.todoapp.data.storage.TaskStorage
import com.example.todoapp.data.storage.database.room.TaskDao
import com.example.todoapp.data.storage.database.room.entities.TaskRoom
import com.example.todoapp.data.storage.model.Task

class TaskStorageDataBaseImp(private val taskDao: TaskDao) : TaskStorage {

    override suspend fun getAllTasks(): List<Task> {
        return mapRoomToData(taskDao.getAllTasks())
    }

    override suspend fun saveTask(task: TaskRoom) {
        taskDao.insertNewTask(task)
    }

    override suspend fun deleteTask(task: TaskRoom) {
        taskDao.removeTask(task)
    }

    fun mapRoomToData(list: List<TaskRoom>): List<Task> {
        val result = mutableListOf<Task>()
        for (i in list) {
            result.add(Task(i.id!!,i.name,i.date,i.isCompleted))
        }
        return result
    }
}