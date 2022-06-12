package com.example.ProductApp.dataSource

import com.example.ProductApp.db.FakeDb
import com.example.ProductApp.model.Products
import javax.inject.Inject

class LocalDataSource @Inject constructor(val fakeDb:FakeDb) {

   suspend fun getProducts() = fakeDb.productDao().getProducts()
    suspend fun saveProducts(products:List<Products>) = fakeDb.productDao().insertProducts(products)
}