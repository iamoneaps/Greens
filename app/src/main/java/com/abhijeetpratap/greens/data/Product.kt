package com.abhijeetpratap.greens.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_products")
class Product(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    var name:String = "Product Name",
    var category: Category = Category.PLANT,
    var price:Double = 0.0)
