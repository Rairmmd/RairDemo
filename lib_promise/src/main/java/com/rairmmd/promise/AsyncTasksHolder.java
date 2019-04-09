package com.rairmmd.promise;

class AsyncTasksHolder<T> extends SameThreadTasksHolder<T> {

    @Override
    protected void notifyListener(final Task<T> task) {
        execute(new Runnable() {
            @Override
            public void run() {
                AsyncTasksHolder.super.notifyListener(task);
            }
        });

    }

    @Override
    protected void notifyErrorListener(final Task<Throwable> task) {
        execute(new Runnable() {
            @Override
            public void run() {
                AsyncTasksHolder.super.notifyErrorListener(task);
            }
        });
    }

    @Override
    protected void notifyListeners(final T data) {
        execute(new Runnable() {
            @Override
            public void run() {
                AsyncTasksHolder.super.notifyListeners(data);
            }
        });
    }

    @Override
    protected void notifyErrorListeners(final Throwable throwable) {
        execute(new Runnable() {
            @Override
            public void run() {
                AsyncTasksHolder.super.notifyErrorListeners(throwable);
            }
        });
    }

    private void execute(Runnable runnable) {
        new Thread(runnable).start();
    }


}