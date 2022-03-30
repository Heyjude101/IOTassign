package com.example.iotassign.repository

import androidx.lifecycle.LiveData
import com.example.iotassign.room.ProductCrud
import com.example.iotassign.room.ProductTable

class ProductRepository(private val ProductCrud:ProductCrud) {

    suspend fun insertProduct (productTable: ProductTable){
        ProductCrud.insertProduct(productTable)

    }

    fun getProduct(): LiveData<List<ProductTable>> {
        return ProductCrud.getProduct()
    }
}