package com.example.iotassign.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductTable")
data class ProductTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val brand: String,
    val description: String,
    val image_link: String,
    val name: String,
    val price: String
)
