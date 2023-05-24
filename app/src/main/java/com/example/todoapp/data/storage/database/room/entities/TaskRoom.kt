package com.example.todoapp.data.storage.database.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class TaskRoom(
    @PrimaryKey val id: Long?,
     val name: String,
     val date: String,
     val isCompleted: Boolean
)
