package com.abhijeetpratap.greens.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class ProductRepository(application: Application) {
    private val database: ProductDatabase = ProductDatabase.getInstance(application)
    private val productDao: ProductDao = database.productDao()

    val allProducts: LiveData<List<Product>> = productDao.allProducts

    fun addUser(product: Product) {
        InsertUser(productDao).execute(product)
    }

    fun deleteUser(product: Product) {
        DeleteUser(productDao).execute(product)
    }

    class InsertUser(private val productDao: ProductDao) : AsyncTask<Product, Unit, Unit>() {
        override fun doInBackground(vararg products: Product?) {
            products[0]?.let { productDao.addProduct(product = it) }
        }
    }

    class DeleteUser(private val productDao: ProductDao) : AsyncTask<Product, Unit, Unit>() {
        override fun doInBackground(vararg products: Product?) {
            products[0]?.let { productDao.deleteProduct(product = it) }
        }
    }
}