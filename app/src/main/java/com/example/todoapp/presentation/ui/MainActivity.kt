package com.example.todoapp.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
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
            val listDataFromDb = getAllTasks.execute()
            runOnUiThread {
                initRecycler(listDataFromDb)
            }
        }

    }

    fun initRecycler(list: List<Task>) {
        var mIth = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: ViewHolder, target: ViewHolder
                ): Boolean {
                    val fromPos = viewHolder.adapterPosition
                    val toPos = target.adapterPosition
                    // move item in `fromPos` to `toPos` in adapter.
                    return true // true if moved, false otherwise
                }

                override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                    val toast = Toast.makeText(applicationContext,"FUCK NIGGERS",Toast.LENGTH_SHORT)
                    toast.show()
                }
            })
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = RecyclerAdapter()
        adapter.bindData(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mIth.attachToRecyclerView(recyclerView)
    }


}