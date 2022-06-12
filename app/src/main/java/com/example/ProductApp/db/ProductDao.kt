package com.example.ProductApp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ProductApp.model.Products

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products :List<Products>):List<Long>

    @Query("SELECT * FROM Products")
    suspend fun getProducts():List<Products>


}