package com.example.usecase

interface ProductsApi {
    suspend fun get(): List<Product>
}