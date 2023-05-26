package com.example.todoapp.presentation.di

import com.example.todoapp.presentation.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        MainViewModel(get(),get(),get(),get(),get(),get())
    }


}