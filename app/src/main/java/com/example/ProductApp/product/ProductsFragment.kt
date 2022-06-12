package com.example.ProductApp.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ProductApp.App
import com.example.ProductApp.ViewModelFactory
import com.example.ProductApp.R
import com.example.ProductApp.model.Products
import com.example.ProductApp.retrofit.NetworkResult
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ProductsFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var productAdapter:ProductAdapter

    lateinit var viewModel: ProductViewModel

    @Inject
    lateinit var productViewModelFactory: ViewModelFactory

    lateinit var rv:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

val     component = (requireActivity().application as App).component
        component.inject(this)

       val map = component.getViewModelMap()

        viewModel = ViewModelProvider(requireActivity(),productViewModelFactory).get(ProductViewModel::class.java)


        viewModel.products.observe(this, Observer { response ->

            when(response){
                is NetworkResult.Loading ->{


                }

                is NetworkResult.Success ->{


                    response.data?.let { setData(it) }
                }

                is NetworkResult.Error ->{

                    Toast.makeText(requireContext(),response.message,Toast.LENGTH_SHORT).show()
                }
            }
        })


        fireEvent()

    }

    fun fireEvent(){
        viewModel.fetchProducts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v = inflater.inflate(R.layout.fragment_products, container, false)

        rv = v.findViewById(R.id.rvProducts)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productAdapter = ProductAdapter()
        initRecylerview()



    }

    fun initRecylerview(){
        rv.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        rv.adapter = productAdapter


    }


    fun setData(data: List<Products>){
       productAdapter.setProducts(data)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}