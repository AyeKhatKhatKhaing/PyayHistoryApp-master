package com.techhousestudio.demobottomnavigation.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.techhousestudio.demobottomnavigation.models.Item;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("Select * From item")
    LiveData<List<Item>> getAllItems();

    @Update
    void updateItem(Item item);

    @Insert
    void insertItem(Item item);

    @Insert
    void insertItems(List<Item> items);

    @Delete
    void deleteItem(Item item);
}
