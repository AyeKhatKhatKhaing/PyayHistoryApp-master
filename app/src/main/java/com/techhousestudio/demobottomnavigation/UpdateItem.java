package com.techhousestudio.demobottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.techhousestudio.demobottomnavigation.models.Item;

public class UpdateItem extends AppCompatActivity {
    public ItemViewModel model;
    public EditText eTitle;
    public EditText eContent;
    public EditText eDate;
    public Button btnUpdate;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);
        btnUpdate=findViewById(R.id.btnUpdate);
        eTitle=findViewById(R.id.edtUpdateTitle);
        eContent=findViewById(R.id.edtUpdateContent);
        //eDate=findViewById(R.id.edtUpdateDate);*/
        model= ViewModelProviders.of(UpdateItem.this).get(ItemViewModel.class);

        intent=getIntent();

        eTitle.setText(intent.getStringExtra("title"));
        eContent.setText(intent.getStringExtra("content"));
        //eDate.setText(intent.getStringExtra("date"));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model.updateItem(new Item(intent.getExtras().getInt("id"),eTitle.getText().toString(),eContent.getText().toString()));
                finish();
            }
        });
    }
}
