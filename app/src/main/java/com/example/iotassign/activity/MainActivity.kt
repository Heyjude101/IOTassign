package com.example.iotassign.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.iotassign.adapter.MyAdapter
import com.example.iotassign.data.MyDataItem
import com.example.iotassign.R
import com.example.iotassign.api.ApiInterface
import com.example.iotassign.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
//    lateinit var recyclerviewUsers: RecyclerView
    private lateinit var binding: ActivityMainBinding

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        recyclerview_users = findViewById(R.id.recyclerview_users)
        binding.recyclerviewUsers.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerviewUsers.layoutManager = linearLayoutManager
        getMyData();
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://makeup-api.herokuapp.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody =  response.body()!!

                myAdapter = MyAdapter(baseContext , responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recyclerviewUsers.adapter = myAdapter


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

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {

            }
        })
    }
}