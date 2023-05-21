package com.example.todoapp.domain.model

data class Task(
    val name: String,
    val date: String,
    val isCompleted: Boolean = false
)
