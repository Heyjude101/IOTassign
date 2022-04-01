package com.example.iotassign.api

import com.example.iotassign.room.ProductTable
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/v1/products.json?brand=maybelline")
    fun getData(): Call<List<ProductTable>>
}