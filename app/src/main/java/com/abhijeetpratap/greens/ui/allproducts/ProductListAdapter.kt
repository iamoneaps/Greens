package com.abhijeetpratap.greens.ui.allproducts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhijeetpratap.greens.R
import com.abhijeetpratap.greens.data.Product
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductListAdapter(private val context: Context) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    private var newProducts: List<Product>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false))
    }

    override fun getItemCount() = newProducts?.size ?: 0

    override fun onBindViewHolder(holder: ProductListAdapter.ProductViewHolder, position: Int) {
        val product = newProducts?.get(position) ?: Product()

//        Glide.with(context).load(cItem.photoUrl).into(holder.image)
        holder.productName.text = product.name
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage = view.product_image
        val productName = view.product_name
        val productPrice = view.product_price
        val productCategory = view.product_category
    }
}