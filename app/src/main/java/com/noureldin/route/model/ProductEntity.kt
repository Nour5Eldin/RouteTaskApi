package com.noureldin.route.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: String,  // Comma-separated String
    val brand: String,
    val sku: String,
    val weight: Double,
    val width: Double,
    val height: Double,
    val depth: Double,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: String,  // JSON String
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val createdAt: String,
    val updatedAt: String,
    val barcode: String,
    val qrCode: String,
    val images: String,  // Comma-separated String
    val thumbnail: String
)