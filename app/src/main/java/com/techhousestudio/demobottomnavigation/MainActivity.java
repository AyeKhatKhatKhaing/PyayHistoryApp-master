package com.techhousestudio.demobottomnavigation;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techhousestudio.demobottomnavigation.adapters.ItemRecyclerAdapter;
import com.techhousestudio.demobottomnavigation.database.ItemAppDatabase;
import com.techhousestudio.demobottomnavigation.models.Item;
import com.techhousestudio.demobottomnavigation.ui.DashBoardFragment;
import com.techhousestudio.demobottomnavigation.ui.HomeFragment;
import com.techhousestudio.demobottomnavigation.ui.NotificationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // widgets

    private Toolbar toolbar;
    private BottomNavigationView navView;
    private AppBarLayout appBar;

//    boolean[] clickState = {false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();



        // set up fragment
        getSupportFragmentManager().beginTransaction().add(R.id.frag_container, new HomeFragment()).commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment currentFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        appBar.setExpanded(true, true);
//                        if (!clickState[0]) {
                        currentFragment = new HomeFragment();
//                            clickState[0] = true;
//                            clickState[1] = false;
//                            clickState[2] = false;
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Twice Home Fragment", Toast.LENGTH_SHORT).show();
//                        }

                        break;
                    case R.id.navigation_dashboard:
//                        if (!clickState[1]) {
                        currentFragment = DashBoardFragment.getInstance();
                        appBar.setExpanded(false);
//                            clickState[0] = false;
//                            clickState[1] = true;
//                            clickState[2] = false;
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Twice Dash Fragment", Toast.LENGTH_SHORT).show();
//                        }

                        break;
                    case R.id.navigation_notifications:
//                        if (!clickState[2]) {
                        appBar.setExpanded(false);
                        currentFragment = NotificationFragment.getInstance();
//                            clickState[0] = false;
//                            clickState[1] = false;
//                            clickState[2] = true;
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Twice Noti Fragment", Toast.LENGTH_SHORT).show();
//                        }

                        break;
                }
                if (currentFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, currentFragment).commit();
                } else {
                    Toast.makeText(getApplicationContext(), "Null Fragment", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navView = findViewById(R.id.nav_view);
        appBar = findViewById(R.id.appbar);

        // fab
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appBar.setExpanded(false, true);
                insertData();
            }
        });

    }

    public void insertData() {
        ItemAppDatabase database = ItemAppDatabase.getInstance(this);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        items.add(new Item("Clip Component", "Clips Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("NavigationView Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("TabLayout Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("RecyclerView Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("Toast Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("Activity Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
//        items.add(new Item("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        database.itemDao().insertItems(items);

    }
}
