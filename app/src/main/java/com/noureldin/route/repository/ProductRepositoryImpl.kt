package com.noureldin.route.repository

import com.noureldin.route.api.ApiService
import com.noureldin.route.model.Product
import com.noureldin.route.api.ApiResponse
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductRepository {
    override suspend fun getProducts(): ApiResponse<List<Product>> {
        return try {
            val response = apiService.getProducts().products
            ApiResponse.Success(response)
        } catch (e: Exception) {
            ApiResponse.Error(e)
        }
    }
}