package com.example.todoapp.data.storage.database.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class TaskRoom(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "task_name") val name: String,
    @ColumnInfo(name = "date_task") val date: String
)
