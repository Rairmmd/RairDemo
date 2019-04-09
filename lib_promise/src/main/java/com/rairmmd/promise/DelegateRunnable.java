package com.rairmmd.promise;

import java.util.concurrent.Callable;

class DelegateRunnable<V> implements Runnable {

    private Callable<V> callable;
    private Deferred<V> deferred;

    DelegateRunnable(Callable<V> callable, Deferred<V> deferred) {
        this.callable = callable;
        this.deferred = deferred;
    }

    @Override
    public void run() {
        try {
            deferred.resolve(callable.call());
        } catch (Throwable throwable) {
            deferred.reject(throwable);
        }
    }
}