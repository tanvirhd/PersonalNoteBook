package com.pdst.personalnotebook.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.pdst.personalnotebook.model.ModelNote;
import com.pdst.personalnotebook.room.NoteDao;
import com.pdst.personalnotebook.room.NoteDatabase;

import java.util.List;

public class RepositoryNote {

    private NoteDao noteDao;

    public RepositoryNote(Application application){
        NoteDatabase db = NoteDatabase.getDb(application);
        noteDao=db.getNoteDao();
    }

    public void insertNewNote(ModelNote modelNote){
        NoteDatabase.databaseWriteExecutor.execute(()->noteDao.insertNewNote(modelNote));
    }

    public void deleteNoteById(int noteId){
        NoteDatabase.databaseWriteExecutor.execute(()->noteDao.deleteNoteById(noteId));
    }

    public LiveData<List<ModelNote>> getAllNotes(){
        return noteDao.getAllNotes();
    }

    public void updateNote(ModelNote modelNote){
        NoteDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                noteDao.updateNote(
                        modelNote.id,
                        modelNote.getNoteTitle(),
                        modelNote.getNoteBody(),
                        modelNote.getModifiedOn(),
                        modelNote.getCategoryId(),
                        modelNote.isPinned(),
                        modelNote.isHasAttachment(),
                        modelNote.isProtected(),
                        modelNote.getNotePassword()
                );
            }
        });
    }
}
