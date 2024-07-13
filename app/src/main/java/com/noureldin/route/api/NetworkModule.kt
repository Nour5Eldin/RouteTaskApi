package com.noureldin.route.api

import android.content.Context
import com.noureldin.route.data.ProductDao
import com.noureldin.route.data.ProductDatabase
import com.noureldin.route.repository.ProductRepository
import com.noureldin.route.repository.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(client)
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
    fun provideDatabase(@ApplicationContext context: Context): ProductDatabase {
        return ProductDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun providesProductDao(database: ProductDatabase): ProductDao {
        return database.productDao()
    }


    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService, productDao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(apiService, productDao)
    }
}