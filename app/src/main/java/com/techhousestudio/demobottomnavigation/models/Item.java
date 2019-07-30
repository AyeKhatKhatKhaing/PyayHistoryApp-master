package com.techhousestudio.demobottomnavigation.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "item")
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String content;
    //public Date create_at;
    //public Date update_at;
   /* @ColumnInfo(name = "like_count")
    public int likeCount;*/

    @Ignore
    public Item(String title, String content) {
        this.title = title;
        this.content = content;
        /*this.create_at = Calendar.getInstance().getTime();
        this.update_at = Calendar.getInstance().getTime();*/
    }

    public Item(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
       /* this.create_at = create_at;
        this.update_at = update_at;
        //this.likeCount = likeCount;*/
    }
}
