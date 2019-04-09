package com.rairmmd.promise;

import android.os.Handler;
import android.os.Looper;

class MainThreadTasksHolder<T> extends SameThreadTasksHolder<T> {

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    @Override
    protected void notifyListener(final Task<T> task) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.notifyListener(task);
        } else {
            HANDLER.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadTasksHolder.super.notifyListener(task);
                }
            });
        }
    }

    @Override
    protected void notifyErrorListener(final Task<Throwable> task) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.notifyErrorListener(task);
        } else {
            HANDLER.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadTasksHolder.super.notifyErrorListener(task);
                }
            });
        }
    }

    @Override
    protected void notifyListeners(final T data) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.notifyListeners(data);
        } else {
            HANDLER.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadTasksHolder.super.notifyListeners(data);
                }
            });
        }
    }

    @Override
    protected void notifyErrorListeners(final Throwable throwable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.notifyErrorListeners(throwable);
        } else {
            HANDLER.post(new Runnable() {
                @Override
                public void run() {
                    MainThreadTasksHolder.super.notifyErrorListeners(throwable);
                }
            });
        }
    }
}