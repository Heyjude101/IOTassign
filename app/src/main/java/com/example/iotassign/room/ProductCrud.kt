package com.example.iotassign.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductCrud {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(productTable: ProductTable)

    @Query("SELECT * FROM ProductTable")
    fun getProduct(): LiveData<List<ProductTable>>
}