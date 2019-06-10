package com.abhijeetpratap.greens

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhijeetpratap.greens.data.Category
import com.abhijeetpratap.greens.data.Product
import com.abhijeetpratap.greens.ui.allproducts.ProductListAdapter
import com.abhijeetpratap.greens.ui.allproducts.ProductsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var productsViewModel: ProductsViewModel
    private val linearLayoutManager = LinearLayoutManager(this)
    private val productListAdapter = ProductListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Products"

        productsViewModel = ViewModelProviders.of(this).get(ProductsViewModel::class.java)

        all_products_holder.apply {
            layoutManager = linearLayoutManager
            adapter = productListAdapter
        }

        productsViewModel.productRepository.allProducts.observe(this, Observer<List<Product>> {
            productListAdapter.newProducts = it
        })

        productsViewModel.productRepository.addProduct(
            Product(
                name = "Sunflower",
                category = Category.FLOWERS,
                price = 123.54
            )
        )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.product_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.filter -> {

            }
        }
        return true
    }
}
