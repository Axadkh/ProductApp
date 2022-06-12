package com.example.ProductApp.retrofit

import retrofit2.Response

abstract class BaseResponse {

    suspend fun <T> safeApiCall(apiCall: suspend  () ->Response<T>):NetworkResult<T>{
        try {

            val call =apiCall()

            if(call.isSuccessful){

              return call.body()?.let { it1 -> NetworkResult.Success(data =it1) }!!
            }

            return  NetworkResult.Error("Error: "+call.errorBody())

        }
        catch (ex:Exception){

            return  NetworkResult.Error("Error: "+ex.localizedMessage)
        }
    }

//    suspend fun <T> safeApiCall(apiCall: suspend ()-> Response<T>):NetworkResult<T>{
//
//        try {
//            val call = apiCall()
//
//            if(call.isSuccessful) {
//                val body =call.body()
//
//                println("asad___>  base response"+body)
//                return call.body()?.let { NetworkResult.Success(data = it) }!!
//            }
//            println("asad___>  base response exception " +call.errorBody())
//            return NetworkResult.Error(call.errorBody().toString())
//
//
//
//        } catch (ex:Exception){
//            println("asad___>  base response exception")
//            ex.printStackTrace()
//            return  NetworkResult.Error(ex.message ?: ex.toString())
//
//        }
//    }

}