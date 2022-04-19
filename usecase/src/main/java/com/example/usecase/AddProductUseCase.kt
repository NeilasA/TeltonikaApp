package com.example.usecase

import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val basketDataSource: BasketDataSource,
) {
    suspend operator fun invoke(product: Product) = basketDataSource.addProduct(product)
}