package com.example.ProductApp.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.ProductApp.product.ProductsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,AppDbModule::class,ViewModelModule::class,NetworkStatusCheckerModule ::class,NetworkStatusCheckerModule::class])
interface AppComponent {


    fun inject(activity:ProductsFragment)

    fun getViewModelMap() : Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory{

        fun  create(@BindsInstance context:Context):AppComponent

    }


}