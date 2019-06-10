package com.abhijeetpratap.greens.ui.allproducts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abhijeetpratap.greens.data.ProductRepository

class ProductsViewModel(application: Application) : AndroidViewModel(application) {
    val productRepository: ProductRepository = ProductRepository(application)
}