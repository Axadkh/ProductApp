package com.example.ProductApp.retrofit

import com.example.ProductApp.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun getProducts():Response<List<Products>>
}