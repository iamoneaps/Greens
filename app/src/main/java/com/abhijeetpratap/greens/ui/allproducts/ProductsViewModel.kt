package com.abhijeetpratap.greens.ui.allproducts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.abhijeetpratap.greens.data.Product
import com.abhijeetpratap.greens.data.ProductRepository

class ProductsViewModel(application: Application) : AndroidViewModel(application) {
    val productRepository: LiveData<List<Product>> = ProductRepository(application).allProducts
}