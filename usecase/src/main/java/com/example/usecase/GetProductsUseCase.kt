package com.example.usecase

import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val api: ProductsApi,
) {
    suspend fun get() = api.get()
}