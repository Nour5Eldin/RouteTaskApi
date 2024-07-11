package com.noureldin.route.api

import com.noureldin.route.model.Product
import com.noureldin.route.model.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}