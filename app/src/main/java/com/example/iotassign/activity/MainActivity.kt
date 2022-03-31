package com.example.iotassign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iotassign.adapter.ProductAdapter
import com.example.iotassign.room.ProductTable
import com.example.iotassign.api.ApiInterface
import com.example.iotassign.databinding.ActivityMainBinding
import com.example.iotassign.repository.ProductRepository
import com.example.iotassign.room.ProductDatabase
import com.example.iotassign.viewmodel.ProductViewModel
import com.example.iotassign.viewmodel.ProductViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
//    private lateinit var recyclerviewUsers: RecyclerView
    val BASE_URL = "INSERT_URL_HERE"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productCrud = ProductDatabase.getProductDatabase(applicationContext).ProductCrud()
        val productRepository = ProductRepository(productCrud)

        val mainViewModel = ViewModelProvider(this , ProductViewModelFactory(productRepository)).get(
            ProductViewModel::class.java)

        val adapter = ProductAdapter()
        binding.recyclerviewUsers.adapter = adapter
        getAndSetMyData(mainViewModel)

        mainViewModel.getProduct().observe(this) {
            adapter.submitList(it)
        }
    }

    private fun getAndSetMyData(viewModel: ProductViewModel) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<ProductTable>?> {
            override fun onResponse(
                call: Call<List<ProductTable>?>,
                response: Response<List<ProductTable>?>
            ) {
                val responseBody =  response.body()!!
                viewModel.insertProduct(responseBody)
                //to do: implement the recycler view
                //we got to use these ones
                //-name
                //-brand
                //-price
                //-image_link
                //-description
                //view binding done
                //now let's do the room database and fetch and store..then we will see how we populate the recycler view

            }

            override fun onFailure(call: Call<List<ProductTable>?>, t: Throwable) {

            }
        })
    }
}