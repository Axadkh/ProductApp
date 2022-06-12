package com.example.ProductApp.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.ProductApp.utils.ConnectionCheck
import com.example.ProductApp.utils.ConnectionCheckImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
 class NetworkStatusCheckerModule {

    @Singleton
    @Provides
    @RequiresApi(Build.VERSION_CODES.M)
     fun hasNetwork(context:Context):ConnectionCheck{
         return  ConnectionCheckImplementation(context)
     }


}