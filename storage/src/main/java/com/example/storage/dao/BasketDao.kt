package com.example.storage.dao

import androidx.room.*
import com.example.storage.ProductEntity
import com.example.storage.ProductEntity.Companion.TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: ProductEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun readBasket(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM $TABLE_NAME WHERE id=:id")
    suspend fun getProductById(id: String): ProductEntity

    @Delete
    suspend fun removeProduct(product: ProductEntity)
}