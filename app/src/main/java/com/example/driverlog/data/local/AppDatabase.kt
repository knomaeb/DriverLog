package com.example.driverlog.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.driverlog.data.local.dao.TransactionDao
import com.example.driverlog.data.local.entity.Transaction

@Database(entities = [Transaction::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    companion object {
        fun getInstance(context: Context): AppDatabase{
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database"
            ).build()
        }
    }

    abstract fun getTransactionDao(): TransactionDao
}