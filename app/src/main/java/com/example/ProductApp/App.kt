package com.example.ProductApp

import android.app.Application
import com.example.ProductApp.di.AppComponent
import com.example.ProductApp.di.DaggerAppComponent


class App : Application() {

lateinit var  component: AppComponent
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.factory().create(this)

    }
}