package com.pdst.personalnotebook.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.pdst.personalnotebook.model.ModelNote;
import com.pdst.personalnotebook.room.NoteDao;
import com.pdst.personalnotebook.room.NoteDatabase;

import java.util.Collections;

public class CreateNoteWork extends Worker {
    private NoteDao noteDao;
    public CreateNoteWork(Context context,WorkerParameters workerParams) {
        super(context, workerParams);
        noteDao= NoteDatabase.getDb(context).getNoteDao();
    }

    @NonNull
    @Override
    public Result doWork() {
        Data inputData=getInputData();
        ModelNote note=new ModelNote(inputData.getString("title"),inputData.getString("body"),
                inputData.getString("modifiedOn"),inputData.getInt("categoryId",0),
                inputData.getBoolean("isPinned",false),inputData.getBoolean("hasAttachment",false),
                inputData.getBoolean("isprotected",false),
                inputData.getString("notePassword")
                );

        try{
            noteDao.insertNewNote(note);
            return Result.success();
        }catch (Exception e){
            Data errorLog=new Data.Builder().putString("sqlerrorlog",e.getMessage()).build();
            return  Result.failure(errorLog);
        }
    }
}
