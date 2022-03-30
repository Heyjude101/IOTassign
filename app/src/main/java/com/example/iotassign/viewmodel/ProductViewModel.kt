package com.example.iotassign.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iotassign.repository.ProductRepository
import com.example.iotassign.room.ProductTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository): ViewModel() {

    fun getProduct(): LiveData<List<ProductTable>> {
        return productRepository.getProduct()
    }

    fun insertProduct(productTable: List<ProductTable>){
        viewModelScope.launch(Dispatchers.IO) {
            for(i in productTable) {
                productRepository.insertProduct(i)
            }
        }
    }
}