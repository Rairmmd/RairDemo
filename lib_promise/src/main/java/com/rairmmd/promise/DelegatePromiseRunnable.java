package com.rairmmd.promise;

class DelegatePromiseRunnable<V> implements Runnable {

    private PromiseCallable<V> callable;
    private Deferred<V> deferred;

    DelegatePromiseRunnable(PromiseCallable<V> callable, Deferred<V> deferred) {
        this.callable = callable;
        this.deferred = deferred;
    }

    @Override
    public void run() {
        callable.call().then(new Task<V>() {
            @Override
            public void run(V data) {
                deferred.resolve(data);
            }
        }).onError(new Task<Throwable>() {
            @Override
            public void run(Throwable data) {
                deferred.reject(data);
            }
        });
    }
}