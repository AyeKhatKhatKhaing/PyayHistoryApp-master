package com.techhousestudio.demobottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.techhousestudio.demobottomnavigation.models.Item;

public class InsertItemActivity extends AppCompatActivity {
    public ItemViewModel model;
    public EditText eTitle;
    public EditText eContent;
    public EditText eDate;
    public Button btnInsert;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_item);
        btnInsert=findViewById(R.id.btnInsert);
        eTitle=findViewById(R.id.edtUpdateTitle);
        eContent=findViewById(R.id.edtUpdateContent);
        //eDate=findViewById(R.id.edtUpdateDate);*/
        model= ViewModelProviders.of(InsertItemActivity.this).get(ItemViewModel.class);

        intent=getIntent();

        /*eTitle.setText(intent.getStringExtra("title"));
        eContent.setText(intent.getStringExtra("content"));
        eDate.setText(intent.getStringExtra("date"));*/
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model.insertItem(new Item(eTitle.getText().toString(),eContent.getText().toString()));
                //finish();
            }
        });

    }
}
