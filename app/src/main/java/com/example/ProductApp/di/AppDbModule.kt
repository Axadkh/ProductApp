package com.example.ProductApp.di

import android.content.Context
import androidx.room.Room
import com.example.ProductApp.db.FakeDb
import com.example.ProductApp.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDbModule {

    @Singleton
    @Provides
    fun provideAppDb(context:Context):FakeDb{
       return Room.databaseBuilder(context,FakeDb::class.java,Constants.BD_NAME)
           .fallbackToDestructiveMigration()
           .allowMainThreadQueries()
           .build()
    }
}