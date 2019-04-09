package com.rairmmd.promise;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class AsyncTaskExecutor implements Executor {

    @Override
    public void execute(@NonNull final Runnable command) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                command.run();
                return null;
            }
        }.execute();
    }
}