package com.pdst.personalnotebook.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pdst.personalnotebook.model.ModelNote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ModelNote.class} , version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    public static NoteDatabase dbInstance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static synchronized NoteDatabase getDb(Context context){
        if(dbInstance==null){
            dbInstance= Room.databaseBuilder(context.getApplicationContext(),NoteDatabase.class,"note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }

}
