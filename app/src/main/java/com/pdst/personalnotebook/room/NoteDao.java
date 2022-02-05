package com.pdst.personalnotebook.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pdst.personalnotebook.model.ModelNote;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNewNote(ModelNote note);

    @Query("Select * from notes where title=(:noteId)")
    ModelNote getNoteByTiId(int noteId);

    @Query("select * from notes")
    LiveData<List<ModelNote>> getAllNotes();

    @Query("delete from notes where id=:noteId")
    void deleteNoteById(int noteId);

    @Query("update notes set title=:noteTitle,body=:noteDes,modifiedOn=:modifiedDate," +
            "CategoryId=:categoryId,isPinned=:isPinned,hasAttachment=:hasAttachment," +
            "isProtected=:isProtected,notePassword=:notePass where id=:id")
    void updateNote(int id,String noteTitle, String noteDes,
                    String modifiedDate, int categoryId, boolean isPinned,
                    boolean hasAttachment, boolean isProtected, String notePass);







    @Insert
    void insertAll(List<ModelNote> notes);

}
