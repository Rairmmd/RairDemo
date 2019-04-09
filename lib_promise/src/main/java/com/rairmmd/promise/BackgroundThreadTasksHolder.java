package com.rairmmd.promise;

import android.os.AsyncTask;
import android.os.Looper;

class BackgroundThreadTasksHolder<T> extends SameThreadTasksHolder<T> {

    @Override
    protected void notifyListener(final Task<T> task) {
        execute(new Runnable() {
            @Override
            public void run() {
                BackgroundThreadTasksHolder.super.notifyListener(task);
            }
        });

    }

    @Override
    protected void notifyErrorListener(final Task<Throwable> task) {
        execute(new Runnable() {
            @Override
            public void run() {
                BackgroundThreadTasksHolder.super.notifyErrorListener(task);
            }
        });
    }

    @Override
    protected void notifyListeners(final T data) {
        execute(new Runnable() {
            @Override
            public void run() {
                BackgroundThreadTasksHolder.super.notifyListeners(data);
            }
        });
    }

    @Override
    protected void notifyErrorListeners(final Throwable throwable) {
        execute(new Runnable() {
            @Override
            public void run() {
                BackgroundThreadTasksHolder.super.notifyErrorListeners(throwable);
            }
        });
    }

    private void execute(Runnable runnable) {
        if (isMainLoop()) {
            executeOnAsyncTask(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean isMainLoop() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void executeOnAsyncTask(final Runnable runnable) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                runnable.run();
                return null;
            }
        }.execute();
    }


}