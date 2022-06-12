package com.example.ProductApp.dataSource

import com.example.ProductApp.retrofit.ApiInterface
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val apiService: ApiInterface) {

    suspend fun getProducts() = apiService.getProducts()

}