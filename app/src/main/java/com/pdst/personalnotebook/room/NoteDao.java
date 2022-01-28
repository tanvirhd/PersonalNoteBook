package com.pdst.personalnotebook.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pdst.personalnotebook.model.ModelNote;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNewNote(ModelNote note);

    @Insert
    void insertAll(List<ModelNote> notes);

    @Query("Select * from notes where title=(:noteId)")
    ModelNote getNoteByTiId(int noteId);

    @Query("SELECT * FROM notes ")
    List<ModelNote> getAllNotes();

}
