package com.noureldin.route.repository

import android.util.Log
import com.noureldin.route.api.ApiService
import com.noureldin.route.model.Product
import com.noureldin.route.api.ApiResponse
import com.noureldin.route.data.ProductDao
import com.noureldin.route.data.toDomain
import com.noureldin.route.data.toEntity
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao
) : ProductRepository {
    override suspend fun getProducts(): ApiResponse<List<Product>> {
        return try {
            val response = apiService.getProducts().products
            productDao.insertAll(response.map { it.toEntity() })
            ApiResponse.Success(response)
        } catch (e: Exception) {
            // Log the error for debugging
            Log.e("ProductRepository", "Failed to fetch products", e)

            val cachedProducts = productDao.getAllProducts().map { it.toDomain() }
            if (cachedProducts.isNotEmpty()) {
                ApiResponse.Success(cachedProducts)
            } else {
                ApiResponse.Error(e)
            }
        }
    }
}