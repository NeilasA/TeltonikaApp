package com.example.api

data class ProductResponse(
    val barcode: String,
    val name: String,
    val description: String,
    val id: String,
    val retailPrice: Int
)