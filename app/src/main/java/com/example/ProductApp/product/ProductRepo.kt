package com.example.ProductApp.product


import com.example.ProductApp.model.Products
import com.example.ProductApp.dataSource.LocalDataSource
import com.example.ProductApp.dataSource.RemoteDataSource
import com.example.ProductApp.retrofit.BaseResponse
import com.example.ProductApp.retrofit.NetworkResult
import com.example.ProductApp.utils.ConnectionCheck
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductRepo @Inject constructor(private  val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val connectionCheck: ConnectionCheck) : BaseResponse() {


    suspend fun geProductsFlow():kotlinx.coroutines.flow.Flow<NetworkResult<List<Products>>> {
        if(connectionCheck.isOnline()) {
           val remoteFlow = flow {
                emit(safeApiCall { remoteDataSource.getProducts() })


            }.flowOn(Dispatchers.IO)

            remoteFlow.collect{
                when(it){
                    is NetworkResult.Success ->{
                        it.data?.let { saveProducts(it) }
                    }
                }
            }
            return  remoteFlow
        }
        else{
            val localFlow = flow {
                val product =localDataSource.getProducts()
                if(product.isEmpty()){
                    emit(NetworkResult.Error("Connection Error"))
                }
                else{

                    emit(NetworkResult.Success(localDataSource.getProducts()))

                }

            }.flowOn(Dispatchers.IO)

            return  localFlow
        }
    }



    suspend fun getProductsFromLocalDataSource():Flow<List<Products>>{
        return flow<List<Products>> {
            emit( localDataSource.getProducts())
        }.flowOn(Dispatchers.IO)


    }

    suspend  fun saveProducts(products: List<Products>):Flow<List<Long>>{
      val insertedItem = flow<List<Long>> {
           localDataSource.saveProducts(products)
       }.flowOn(Dispatchers.IO)

        insertedItem.collect{
            println("asad----------> " +it.size)
        }
        return  insertedItem
    }





    }





