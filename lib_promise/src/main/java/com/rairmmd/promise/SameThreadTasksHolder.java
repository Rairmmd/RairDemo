package com.rairmmd.promise;

class SameThreadTasksHolder<T> extends TasksHolder<T> {

    @Override
    protected void notifyListener(Task<T> task) {
        if (isSuccessful()) {
            task.run(getData());
        }
    }

    @Override
    protected void notifyErrorListener(Task<Throwable> task) {
        if (!isSuccessful()) {
            task.run(getError());
        }
    }

    @Override
    protected void notifyListeners(T data) {
        for (Task<T> task : getTasks()) {
            task.run(data);
        }
    }

    @Override
    protected void notifyErrorListeners(Throwable throwable) {
        for (Task<Throwable> task : getErrorTasks()) {
            task.run(throwable);
        }
    }


}