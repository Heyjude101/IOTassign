package com.example.iotassign

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/v1/products.json?brand=maybelline")
    fun getData(): Call<List<MyDataItem>>
}