package com.example.ProductApp.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ProductApp.model.Products
import com.example.ProductApp.retrofit.NetworkResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val repo: ProductRepo): ViewModel() {

    private val _products:MutableLiveData<NetworkResult<List<Products>>> = MutableLiveData()

    val products:LiveData<NetworkResult<List<Products>>> = _products


    fun fetchProducts() {
        if(_products.value == null){
        viewModelScope.launch {
            repo.geProductsFlow().collect { values ->
                _products.value = values
            }
        }

    }
    }



}