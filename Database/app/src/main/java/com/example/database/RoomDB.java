package com.example.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

// Add database entities
@Database(entities = {MainData.class},version = 1,exportSchema = false)

public abstract class RoomDB extends RoomDatabase {
    //creating database instances
    private static RoomDB database;

    public synchronized static void getInstance(Context context) {
        if (database == null) {
            // Defining database name
            String DATABASE_NAME = "database";
            database= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();}

        }

    public MainDao mainDao() {
        return null;
    }
}

