package com.abhijeetpratap.greens.data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@androidx.room.Database(entities = {Product.class}, version = 2)
@TypeConverters(CategoryConverter.class)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase INSTANCE;

    public static ProductDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductDatabase.class, "items_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ProductDao productDao();
}
