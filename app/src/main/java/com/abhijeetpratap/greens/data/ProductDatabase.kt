package com.abhijeetpratap.greens.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var instance: ProductDatabase? = null
        private val DATABASE_NAME = "all_products"

        fun getInstance(context: Context): ProductDatabase {
            return instance ?: synchronized(this) {
                instance ?: builDatabase(context).also {
                    instance = it
                }
            }
        }

        private fun builDatabase(context: Context): ProductDatabase {
            return Room.databaseBuilder(
                context,
                ProductDatabase::class.java, DATABASE_NAME
            ).build()
        }
    }
}
