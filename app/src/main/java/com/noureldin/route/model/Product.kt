package com.noureldin.route.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val tags: List<String>,
    val brand: String,
    val sku: String,
    val weight: Double,
    val dimensions: Dimensions,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<Review>,
    val returnPolicy: String,
    val minimumOrderQuantity: Int,
    val meta: Meta,
    val images: List<String>,
    val thumbnail: String
)

data class Dimensions(val width: Double, val height: Double, val depth: Double)
data class Review(val rating: Int, val comment: String, val date: String, val reviewerName: String, val reviewerEmail: String)
data class Meta(val createdAt: String, val updatedAt: String, val barcode: String, val qrCode: String)
