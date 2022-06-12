package com.example.ProductApp.di

import androidx.lifecycle.ViewModel
import com.example.ProductApp.product.ProductViewModel
import com.example.ProductApp.productDetails.ProductDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @ClassKey(ProductViewModel::class)
    @IntoMap
   abstract fun getProductViewModel(productViewModel: ProductViewModel):ViewModel


    @Binds
    @ClassKey(ProductDetailsViewModel::class)
    @IntoMap
    abstract fun getProductDetailsViewModel(productDetailsViewModel: ProductDetailsViewModel):ViewModel
}