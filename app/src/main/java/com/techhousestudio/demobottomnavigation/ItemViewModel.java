package com.techhousestudio.demobottomnavigation;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.techhousestudio.demobottomnavigation.models.Item;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    ItemRepository repository;
    public LiveData<List<Item>> items;
    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository=new ItemRepository(application);
        items = repository.getItems();

    }
    public LiveData<List<Item>> getItems(){return  items;}
    void insertItem(Item item){
        repository.insertItem(item);
    }
    public void deleteItem(Item item){repository.deleteItem(item);}
    void updateItem(Item item){repository.updateItem(item);}

}
