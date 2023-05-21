package com.example.todoapp.data.storage.model

data class Task(
    val name: String,
    val date: String,
    val isCompleted: Boolean = false

)
