package com.techhousestudio.demobottomnavigation.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.techhousestudio.demobottomnavigation.ItemViewModel;
import com.techhousestudio.demobottomnavigation.R;
import com.techhousestudio.demobottomnavigation.InsertItemActivity;
import com.techhousestudio.demobottomnavigation.adapters.ItemRecyclerAdapter;
import com.techhousestudio.demobottomnavigation.database.ItemAppDatabase;
import com.techhousestudio.demobottomnavigation.models.Item;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public ItemViewModel model;
    public ItemRecyclerAdapter adapter;
    public RecyclerView itemList;

    // widget
    private RecyclerView article_list;


    // var
    private static HomeFragment INSTANCE;
    private ItemAppDatabase database;

//    public static synchronized HomeFragment getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new HomeFragment();
//        }
//        return (INSTANCE);
//    }

    public HomeFragment() {
        Log.d("WKKN", "Call Fragment");
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemList=view.findViewById(R.id.article_list);
        itemList.setLayoutManager(new LinearLayoutManager(getContext()));

        itemList.setItemAnimator(new DefaultItemAnimator());
        adapter=new ItemRecyclerAdapter(getContext());
        itemList.setAdapter(adapter);


        model= ViewModelProviders.of((FragmentActivity) getContext()).get(ItemViewModel.class);
        model.getItems().observe(this, new Observer<List<Item>>() {

            @Override
            public void onChanged(List<Item> items) {

                Toast.makeText(getContext(),items.size()+"",Toast.LENGTH_SHORT).show();
                adapter.setItems(items);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {



                Item item=adapter.getItems().get(viewHolder.getAdapterPosition());
                model.deleteItem(item);
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        }).attachToRecyclerView(itemList);

        view.findViewById(R.id.fab1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), InsertItemActivity.class);
                startActivity(intent);
                //model.insertUser(new User("AK","093243353","3cs2"));
            }
        });

    }


}
