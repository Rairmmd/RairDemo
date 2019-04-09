package com.rairmmd.promise;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;


public class Executable {

    private Executor executor;

    public Executable(Executor executor) {
        this.executor = executor;
    }

    public <V> Promise<V> execute(final PromiseCallable<V> callable) {
        final Deferred<V> deferred = Deferred.newDeferred();
        Runnable runnable = new DelegatePromiseRunnable<V>(callable, deferred);
        if (Function.sync) {
            runnable.run();
        } else {
            executor.execute(runnable);
        }
        return deferred;
    }

    public <V> Promise<V> execute(Callable<V> callable) {
        final Deferred<V> deferred = Deferred.newDeferred();
        Runnable runnable = new DelegateRunnable<V>(callable, deferred);
        if (Function.sync) {
            runnable.run();
        } else {
            executor.execute(runnable);
        }
        return Function.sync ? deferred : new PromiseDecorator<V>(deferred);
    }

    private static class PromiseDecorator<T> implements Promise<T> {

        private Promise<T> delegate;

        PromiseDecorator(Promise<T> delegate) {
            this.delegate = delegate;
        }

        @Override
        public Promise<T> then(Task<T> task) {
            return delegate.thenOnBackgroundThread(task);
        }

        @Override
        public Promise<T> thenOnMainThread(Task<T> task) {
            return delegate.thenOnMainThread(task);
        }

        @Override
        public Promise<T> thenOnBackgroundThread(Task<T> task) {
            return thenOnBackgroundThread(task);
        }

        @Override
        public Promise<T> thenAsync(Task<T> task) {
            return delegate.thenAsync(task);
        }

        @Override
        public Promise<T> onError(Task<Throwable> task) {
            return delegate.onErrorOnBackgroundThread(task);
        }

        @Override
        public Promise<T> onErrorOnMainThread(Task<Throwable> task) {
            return delegate.onErrorOnMainThread(task);
        }

        @Override
        public Promise<T> onErrorOnBackgroundThread(Task<Throwable> task) {
            return delegate.onErrorOnBackgroundThread(task);
        }

        @Override
        public Promise<T> onErrorAsync(Task<Throwable> task) {
            return delegate.onErrorAsync(task);
        }

        @Override
        public <V> Promise<V> convert(Converter<T, V> converter) {
            return delegate.convert(converter);
        }
    }
}
