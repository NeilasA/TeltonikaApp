package com.example.usecase

data class Product(
    val pk: Int? = null,
    val barcode: String,
    val name: String,
    val description: String,
    val id: String,
    val retailPrice: Int,
)
