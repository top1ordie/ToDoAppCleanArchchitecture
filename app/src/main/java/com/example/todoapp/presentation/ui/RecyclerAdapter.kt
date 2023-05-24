package com.example.todoapp.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.domain.model.Task

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.TaskViewHolder>() {

    private var dataList = mutableListOf<Task>()
    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView
        private val dateView: TextView

        init {
            nameView = view.findViewById(R.id.name_task)
            dateView = view.findViewById(R.id.date_task)
        }

        fun onBind(task: Task) {
            nameView.text = task.name
            dateView.text = task.date
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun bindData(list: List<Any>){
        dataList = list as MutableList<Task>
    }
}