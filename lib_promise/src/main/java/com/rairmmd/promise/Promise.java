package com.rairmmd.promise;

public interface Promise<T> {

    Promise<T> then(Task<T> task);

    Promise<T> thenOnMainThread(Task<T> task);

    Promise<T> thenOnBackgroundThread(Task<T> task);

    Promise<T> thenAsync(Task<T> task);

    Promise<T> onError(Task<Throwable> task);

    Promise<T> onErrorOnMainThread(Task<Throwable> task);

    Promise<T> onErrorOnBackgroundThread(Task<Throwable> task);

    Promise<T> onErrorAsync(Task<Throwable> task);

    <V> Promise<V> convert(Converter<T, V> converter);

}