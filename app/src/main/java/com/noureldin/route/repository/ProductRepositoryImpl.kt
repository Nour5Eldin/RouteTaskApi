package com.noureldin.route.repository

import com.noureldin.route.api.ApiService
import com.noureldin.route.model.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return apiService.getProducts().products
    }
}