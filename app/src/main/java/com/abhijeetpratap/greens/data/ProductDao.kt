package com.abhijeetpratap.greens.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

    @get:Query("SELECT * FROM all_products")
    val allProducts:LiveData<List<Product>>
}