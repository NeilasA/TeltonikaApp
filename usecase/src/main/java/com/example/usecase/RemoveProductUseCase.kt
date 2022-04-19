package com.example.usecase

import javax.inject.Inject

class RemoveProductUseCase @Inject constructor(
    private val basketDataSource: BasketDataSource
){
    suspend operator fun invoke(product: Product) = basketDataSource.removeProduct(product)
}