package com.example.driverlog.core.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.example.driverlog.core.utils.dataStore
import com.example.driverlog.data.local.AppDatabase
import com.example.driverlog.data.local.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) : DataStore<Preferences>{
        return context.dataStore
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : AppDatabase{
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideTransactionDao(db: AppDatabase): TransactionDao = db.getTransactionDao()


}