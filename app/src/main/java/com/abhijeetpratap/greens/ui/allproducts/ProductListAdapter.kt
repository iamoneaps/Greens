package com.abhijeetpratap.greens.ui.allproducts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhijeetpratap.greens.R
import com.abhijeetpratap.greens.data.Product
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.product_list_item.view.*

class ProductListAdapter(private val context: Context) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    var newProducts: List<Product>? = null
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

        Glide.with(context)
            .load("https://us.123rf.com/450wm/cobalt/cobalt1508/cobalt150800043/44225996-stock-vector-sunflower-isolated-vector-illustration-.jpg?ver=6")
            .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(16)))
            .into(holder.productImage)

        holder.productName.text = product.name
        holder.productCategory.text = product.category.name
        holder.productPrice.text = "${product.price}"
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage = view.product_image
        val productName = view.product_name
        val productPrice = view.product_price
        val productCategory = view.product_category
    }
}