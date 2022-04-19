package com.example.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.storage.ProductEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val pk : Int = 0,
    val barcode: String,
    val name: String,
    val description: String,
    val id: String,
    val retailPrice: Int,
) {
    companion object {
        const val TABLE_NAME = "basket_table"
    }
}
