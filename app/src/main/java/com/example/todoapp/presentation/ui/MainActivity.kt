package com.example.todoapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todoapp.R
import com.example.todoapp.data.TaskRepositoryImpl
import com.example.todoapp.data.storage.database.TaskStorageDataBaseImp
import com.example.todoapp.data.storage.database.room.AppDatabase
import com.example.todoapp.domain.GetAllTasks
import com.example.todoapp.domain.RemoveTask
import com.example.todoapp.domain.SaveTask
import com.example.todoapp.domain.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "task.db").build().dao
        val taskStorage = TaskStorageDataBaseImp(db)
        val taskRepository = TaskRepositoryImpl(taskStorage)
        val getAllTasks = GetAllTasks(taskRepository)
        val removeTask = RemoveTask(taskRepository)
        val saveTask = SaveTask(taskRepository)
        CoroutineScope(Dispatchers.IO).launch {
            saveTask.execute(Task(1, "Атжуманя", "2023-05-24"))

        }

    }

    fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = RecyclerAdapter()
        adapter.bindData(listOf(Task(1, "1", "2", false), Task(2, "1", "2", false)))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}