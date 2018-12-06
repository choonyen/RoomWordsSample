package com.example.taruc.roomwordssample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    public static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (WordRoomDatabase.class)
            {
                if(INSTANCE == null)
                {
                    //CREATE DATABASE HERE
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database")
                            //wipes and rebuilds insteads of migrating
                            //if no migration object
                            //migration is not part of this practical
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;

    }
}
