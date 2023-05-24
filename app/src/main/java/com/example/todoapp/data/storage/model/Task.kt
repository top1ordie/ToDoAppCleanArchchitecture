package com.example.todoapp.data.storage.model

data class Task(
    val id: Long,
    val name: String,
    val date: String,
    val isCompleted: Boolean = false

)
