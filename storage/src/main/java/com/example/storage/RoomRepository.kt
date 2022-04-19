package com.example.storage

import com.example.storage.dao.BasketDao
import com.example.usecase.BasketDataSource
import com.example.usecase.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val basketDao: BasketDao
) : BasketDataSource {

    override suspend fun addProduct(product: Product) {
        basketDao.addProduct(
            mapProductToBasketEntity(product)
        )
    }

    override fun readBasket(): Flow<List<Product>> =
        basketDao.readBasket().map { products ->
            products.map {
                Product(
                    it.pk,
                    it.barcode,
                    it.name,
                    it.description,
                    it.id,
                    it.retailPrice,
                )
            }
        }

    override suspend fun removeProduct(product: Product) {
        basketDao.removeProduct(
            mapProductToBasketEntity(product)
        )
    }

    override suspend fun getProductById(id: String): Product {
        val product = basketDao.getProductById(id)
        return Product(
            product.pk,
            product.barcode,
            product.name,
            product.description,
            product.id,
            product.retailPrice,
        )
    }

    private fun mapProductToBasketEntity(product: Product): ProductEntity =
        ProductEntity(
            pk = product.pk ?: 0,
            barcode = product.barcode,
            name = product.name,
            description = product.description,
            id = product.id,
            retailPrice = product.retailPrice,
        )
}