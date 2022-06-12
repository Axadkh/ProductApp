package com.example.ProductApp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
open class Products(
@PrimaryKey (autoGenerate = false)
    @SerializedName("id"          ) var id          : Int?    = null,
    @SerializedName("title"       ) var title       : String? = null,
    @SerializedName("price"       ) var price       : Double? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("category"    ) var category    : String? = null,
    @SerializedName("image"       ) var image       : String? = null,
//@TypeConverters(MConvertor.class)
//    @SerializedName("rating"      ) var rating      : Rating? = Rating()
)
