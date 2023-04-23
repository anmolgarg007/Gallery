package com.example.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//Define table name
@Entity(tableName = "table_name")
public class MainData {
    //create id coloumn ;
    private int Id;
    @ColumnInfo(name = "text")
    private String text;
    //generating getter and setter

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
