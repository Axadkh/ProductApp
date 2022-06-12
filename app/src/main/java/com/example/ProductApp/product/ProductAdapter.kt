package com.example.ProductApp.product

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ProductApp.R
import com.example.ProductApp.model.Products

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

private val products :ArrayList<Products> = ArrayList()


    @SuppressLint("NotifyDataSetChanged")
    fun setProducts(products: List<Products>){
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.product_item,parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        products.get(position).title?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
       return products.size
    }

    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {

        val productName :TextView

        init {
            productName = v.findViewById(R.id.pName)
        }
        fun bind(name:String){

            productName.text = name
        }

    }
}