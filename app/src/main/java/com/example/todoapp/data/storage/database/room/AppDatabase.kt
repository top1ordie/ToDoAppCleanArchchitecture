package com.example.todoapp.data.storage.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.storage.database.room.TaskDao
import com.example.todoapp.data.storage.database.room.entities.TaskRoom

@Database(
    version = 1,
    entities = [TaskRoom::class]
)
abstract class AppDatabase : RoomDatabase(){

    abstract val dao: TaskDao

}