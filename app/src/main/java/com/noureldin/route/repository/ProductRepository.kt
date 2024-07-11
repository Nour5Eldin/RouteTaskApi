package com.noureldin.route.repository


import com.noureldin.route.model.Product


interface ProductRepository {
    suspend fun getProducts(): List<Product>
}