package com.example.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.icu.text.Replaceable;

import androidx.annotation.RequiresPermission;

import java.util.List;

@Dao
public interface MainDao {
    //Insert query
    @Insert
    default void insert(MainData mainData) {

    }

    //deleteing the query
    @Delete
    void delete (MainData mainData);

    //deleting all the query
    @Delete
    void reset(List<MainData> mainData);
    @Update
    @Query("Update table_name SET text= :sText WHERE ID=:sID")
    void update (int sID,String sText);
    //get all data query
    @Query("Select *FROM table_name")
    List<MainData> getAll();
}
