package com.abhijeetpratap.greens.data

import androidx.room.TypeConverter

class CategoryConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun getCategoryName(category: Category): String {
            return when (category) {
                Category.FLOWERS -> "Flowers"
                Category.SHRUBS -> "Shrubs"
                Category.PLANT -> "Plant"
                Category.DEFAULT -> "Product"
            }
        }

        @TypeConverter
        @JvmStatic
        fun getCategoryObject(category: String): Category {
            return when (category) {
                "Flowers" -> Category.FLOWERS
                "Shrubs" -> Category.SHRUBS
                "Plant" -> Category.PLANT
                else -> Category.DEFAULT
            }
        }
    }
}

