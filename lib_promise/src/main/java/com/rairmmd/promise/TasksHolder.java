package com.rairmmd.promise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

abstract class TasksHolder<T> {

    private List<Task<T>> tasks = new ArrayList<>();
    private List<Task<Throwable>> errorTasks = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private boolean resolved;

    private boolean successful;
    private T data;
    private Throwable error;

    void add(Task<T> task) {
        lock.lock();
        try {
            if (resolved) {
                notifyListener(task);
            } else {
                tasks.add(task);
            }
        } finally {
            lock.unlock();
        }
    }

    protected abstract void notifyListener(Task<T> task);

    void addOnError(Task<Throwable> task) {
        lock.lock();
        try {
            if (resolved) {
                notifyErrorListener(task);
            } else {
                errorTasks.add(task);
            }
        } finally {
            lock.unlock();
        }
    }

    protected abstract void notifyErrorListener(Task<Throwable> task);

    protected boolean isSuccessful() {
        return successful;
    }

    protected Throwable getError() {
        return error;
    }

    protected T getData() {
        return data;
    }

    protected List<Task<T>> getTasks() {
        return tasks;
    }

    protected List<Task<Throwable>> getErrorTasks() {
        return errorTasks;
    }

    void resolve(T data) {
        lock.lock();
        try {
            markAsResolved();
            this.successful = true;
            this.data = data;
            if (!tasks.isEmpty()) {
                notifyListeners(data);
            }
        } finally {
            lock.unlock();
        }
    }

    protected abstract void notifyListeners(T data);

    public void reject(Throwable throwable) {
        lock.lock();
        try {
            markAsResolved();
            this.successful = false;
            this.error = throwable;
            if (!errorTasks.isEmpty()) {
                notifyErrorListeners(throwable);
            }
        } finally {
            lock.unlock();
        }
    }

    protected abstract void notifyErrorListeners(Throwable throwable);

    private void markAsResolved() {
        if (resolved) {
            throw new IllegalStateException("Deferred already resolved");
        }
        resolved = true;
    }

}
