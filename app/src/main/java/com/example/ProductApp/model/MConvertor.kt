package com.example.ProductApp.model

import androidx.room.TypeConverter


open class MConvertor {


    @TypeConverter
    fun getRatingCounr(rate: Rating?): Int? {
        return rate?.count
    }

    @TypeConverter
    fun getRatingRate(rate: Rating?): Double? {
        return rate?.rate
    }
    }



