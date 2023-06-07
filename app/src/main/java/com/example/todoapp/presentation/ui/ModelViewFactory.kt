package com.example.todoapp.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.domain.GetAllTasks

class ModelViewFactory(val getAllTasks: GetAllTasks) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getAllTasks = getAllTasks) as T
    }
}