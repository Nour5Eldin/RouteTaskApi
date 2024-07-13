package com.noureldin.route.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noureldin.route.model.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(producs: List<ProductEntity>)

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<ProductEntity>
}