package com.pdst.personalnotebook.workmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class GetAllNoteWork extends Worker {

    public GetAllNoteWork(Context context,WorkerParameters workerParams) {
        super(context, workerParams);


    }

    @NonNull
    @Override
    public Result doWork() {
        return  null;
    }
}
