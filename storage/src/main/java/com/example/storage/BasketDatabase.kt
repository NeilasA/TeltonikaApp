package com.example.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.storage.dao.BasketDao

@Database(entities = [ProductEntity::class], version = 1)
abstract class BasketDatabase : RoomDatabase() {
    abstract fun basketDao(): BasketDao
}