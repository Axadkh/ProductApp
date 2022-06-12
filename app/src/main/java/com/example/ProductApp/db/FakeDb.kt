package com.example.ProductApp.db

import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.ProductApp.model.Products
import com.example.ProductApp.utils.Constants


@Database(entities = [Products::class], version = Constants.DB_VERSION)
abstract class FakeDb:RoomDatabase() {

    abstract fun productDao(): ProductDao


}