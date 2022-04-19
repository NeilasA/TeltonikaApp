package com.example.usecase

import javax.inject.Inject

class GetBasketUseCase @Inject constructor(
    private val dataSource: BasketDataSource
) {
    operator fun invoke() = dataSource.readBasket()
}