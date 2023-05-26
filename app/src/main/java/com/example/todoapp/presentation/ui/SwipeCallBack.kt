package com.example.todoapp.presentation.ui

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class SwipeCallBack(private val context: Context): ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
    ItemTouchHelper.LEFT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
    ): Boolean {
        val fromPos = viewHolder.adapterPosition
        val toPos = target.adapterPosition
        // move item in `fromPos` to `toPos` in adapter.
        return true // true if moved, false otherwise
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val toast =
            Toast.makeText(context, "FUCK NIGGERS", Toast.LENGTH_SHORT)
        toast.show()
    }
}