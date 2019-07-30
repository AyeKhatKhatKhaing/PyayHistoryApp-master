package com.techhousestudio.demobottomnavigation;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.techhousestudio.demobottomnavigation.database.ItemAppDatabase;
import com.techhousestudio.demobottomnavigation.database.ItemDao;
import com.techhousestudio.demobottomnavigation.models.Item;

import java.util.List;

public class ItemRepository {
    ItemAppDatabase db;
    private ItemDao userDao;
    private LiveData<List<Item>> users;
    public ItemRepository(Application application) {

        db = ItemAppDatabase.getInstance(application);

        userDao=db.itemDao();
        users=db.itemDao().getAllItems();

    }
    public LiveData<List<Item>> getItems(){
        return users;
    }
    public void insertItem(final Item item){
        new AppExecutors().diskIO().execute(() -> userDao.insertItem(item));
    }
    public void deleteItem(Item item){
        new AppExecutors().diskIO().execute(()->userDao.deleteItem(item));
    }
    public void updateItem(Item item){
        new AppExecutors().diskIO().execute(() -> userDao.updateItem(item));
    }

}
