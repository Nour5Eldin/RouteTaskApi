package com.noureldin.route.api

import com.noureldin.route.repository.ProductRepository
import com.noureldin.route.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }
}