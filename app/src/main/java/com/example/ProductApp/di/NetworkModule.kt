package com.example.ProductApp.di

import com.example.ProductApp.retrofit.ApiInterface
import com.example.ProductApp.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{

        return  Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):ApiInterface{
        return  retrofit.create(ApiInterface::class.java)
    }

}