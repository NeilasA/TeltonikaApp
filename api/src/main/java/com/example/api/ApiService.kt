package com.example.api

import com.example.usecase.Product
import javax.inject.Inject

class ApiService @Inject constructor(
    private val api: ProductsApi
) : com.example.usecase.ProductsApi {
    override suspend fun get(): List<Product> {
        return api.getProducts().data.map { product ->
            Product(
                barcode = product.barcode,
                name = product.name,
                description = product.description,
                id = product.id,
                retailPrice = product.retailPrice,
            )
        }
    }
}