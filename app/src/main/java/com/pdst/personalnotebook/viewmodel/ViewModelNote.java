package com.pdst.personalnotebook.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pdst.personalnotebook.model.ModelNote;
import com.pdst.personalnotebook.repository.RepositoryNote;

import java.util.List;

public class ViewModelNote extends AndroidViewModel {

    private RepositoryNote repositoryNote;

    public ViewModelNote(Application application) {
        super(application);
        repositoryNote=new RepositoryNote(application);
    }

    public void insertNewNote(ModelNote note){
        repositoryNote.insertNewNote(note);
    }

    public void deleteNoteById(int id){
        repositoryNote.deleteNoteById(id);
    }

    public LiveData<List<ModelNote>> getAllNotes(){
        return repositoryNote.getAllNotes();
    }

    public void updateNote(ModelNote note){
        repositoryNote.updateNote(note);
    }
}
