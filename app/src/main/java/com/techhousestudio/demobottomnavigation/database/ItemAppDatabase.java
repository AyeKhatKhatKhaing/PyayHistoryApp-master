package com.techhousestudio.demobottomnavigation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.techhousestudio.demobottomnavigation.models.Item;

@Database(entities = {Item.class}, version = 2,exportSchema = false)
//@TypeConverters({Converters.class})
public abstract class ItemAppDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();

    private static ItemAppDatabase sInstance;

    public static ItemAppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (new Object()) {
                sInstance = Room.databaseBuilder(context, ItemAppDatabase.class, "pyay-history-guide")

                        .allowMainThreadQueries()

                        .build();
            }
        }
        return sInstance;
    }


}
