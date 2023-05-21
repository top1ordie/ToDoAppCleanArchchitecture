package com.example.todoapp.data.storage.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.data.storage.database.room.entities.TaskRoom

@Dao
interface TaskDao {
    @Insert(entity = TaskRoom::class)
    fun insertNewTask(task: TaskRoom)

    @Query("DELETE FROM task WHERE id = :taskId")
    fun removeTask(taskId: Int)
}