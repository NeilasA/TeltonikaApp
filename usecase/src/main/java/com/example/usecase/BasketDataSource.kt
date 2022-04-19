package com.example.usecase

import kotlinx.coroutines.flow.Flow

interface BasketDataSource {

    suspend fun addProduct(product: Product)

    fun readBasket(): Flow<List<Product>>

    suspend fun removeProduct(product: Product)

    suspend fun getProductById(id: String): Product
}