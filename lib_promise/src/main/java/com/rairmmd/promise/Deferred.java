package com.rairmmd.promise;

public class Deferred<T> implements Promise<T> {

    private TasksHolder tasks = new SameThreadTasksHolder();
    private TasksHolder mainThreadTasks = new MainThreadTasksHolder();
    private TasksHolder backgroundThreadTasks = new BackgroundThreadTasksHolder();
    private TasksHolder asyncTasks = new AsyncTasksHolder();

    protected Deferred() {
    }

    public static <T> Deferred<T> newDeferred() {
        return new Deferred<T>();
    }

    @Override
    public Promise<T> then(Task<T> task) {
        tasks.add(task);
        return this;
    }

    @Override
    public Promise<T> thenOnMainThread(Task<T> task) {
        mainThreadTasks.add(task);
        return this;
    }

    @Override
    public Promise<T> thenAsync(Task<T> task) {
        asyncTasks.add(task);
        return this;
    }

    @Override
    public Promise<T> thenOnBackgroundThread(Task<T> task) {
        backgroundThreadTasks.add(task);
        return this;
    }

    @Override
    public Promise<T> onError(Task<Throwable> task) {
        tasks.addOnError(task);
        return this;
    }

    @Override
    public Promise<T> onErrorOnMainThread(Task<Throwable> task) {
        mainThreadTasks.addOnError(task);
        return this;
    }

    @Override
    public Promise<T> onErrorAsync(Task<Throwable> task) {
        asyncTasks.addOnError(task);
        return this;
    }

    @Override
    public Promise<T> onErrorOnBackgroundThread(Task<Throwable> task) {
        backgroundThreadTasks.addOnError(task);
        return this;
    }

    public void resolve(T data) {
        tasks.resolve(data);
        mainThreadTasks.resolve(data);
        backgroundThreadTasks.resolve(data);
        asyncTasks.resolve(data);
    }

    public void reject() {
        reject(null);
    }

    public void reject(Throwable throwable) {
        tasks.reject(throwable);
        mainThreadTasks.reject(throwable);
        backgroundThreadTasks.reject(throwable);
        asyncTasks.reject(throwable);
    }

    @Override
    public <V> Promise<V> convert(final Converter<T, V> converter) {
        final Deferred<V> deferred = newDeferred();
        then(new Task<T>() {
            @Override
            public void run(T data) {
                try {
                    deferred.resolve(converter.transform(data));
                } catch (Exception ex) {
                    deferred.reject(ex);
                }
            }
        });
        onError(new Task<Throwable>() {
            @Override
            public void run(Throwable data) {
                deferred.reject(data);
            }
        });
        return deferred;
    }
}
