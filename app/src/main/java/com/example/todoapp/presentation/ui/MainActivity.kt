package com.example.todoapp.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.domain.GetAllTasks
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {
    private lateinit var  mainViewModel: MainViewModel
    val getAllTasks: GetAllTasks by inject()
    lateinit var recyclerView: RecyclerView
    val adapter = RecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this,ModelViewFactory(getAllTasks)).get(MainViewModel::class.java)
        val addButton = findViewById<FloatingActionButton>(R.id.add_button)
        addButton.setOnClickListener {
            val dialog = CreateTaskDialog()
            dialog.show(supportFragmentManager, "Dialog")
        }
        mainViewModel.someShit()
        /*mainViewModel._list.observe(this, {
            adapter.bindData(it)
        })*/

        CoroutineScope(Dispatchers.IO).launch {
            adapter.bindData(getAllTasks.execute())
            runOnUiThread{
                initRecycler()
            }

        }




    }

    fun initRecycler() {
        var mIth = ItemTouchHelper(SwipeCallBack(applicationContext))
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mIth.attachToRecyclerView(recyclerView)
    }


}