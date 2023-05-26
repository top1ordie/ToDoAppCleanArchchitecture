package com.example.todoapp.data.storage.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.data.storage.database.room.entities.TaskRoom
import com.example.todoapp.data.storage.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insertNewTask(task: TaskRoom)

    @Delete
    suspend fun removeTask(task: TaskRoom)

    @Query("SELECT * FROM Task")
    suspend fun getAllTasks(): List<TaskRoom>

}