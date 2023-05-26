package com.example.todoapp.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModel<MainViewModel>()
    lateinit var recyclerView: RecyclerView
    val adapter = RecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<FloatingActionButton>(R.id.add_button)
        addButton.setOnClickListener {
            val dialog = CreateTaskDialog()
            dialog.show(supportFragmentManager, "Dialog")
        }
        mainViewModel.someShit()
        /*mainViewModel._list.observe(this, {
            adapter.bindData(it)
        })*/

        mainViewModel._list.value?.let {
            for (i in it) {
                Log.d("TaskValuesFromVM" ,"id: ${i.id}")
            }
            adapter.bindData(it)

        }
        initRecycler()


    }

    fun initRecycler() {
        var mIth = ItemTouchHelper(SwipeCallBack(applicationContext))
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mIth.attachToRecyclerView(recyclerView)
    }


}