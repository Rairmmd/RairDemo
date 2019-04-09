package com.rairmmd.promise;

public interface PromiseCallable<T> {

    Promise<T> call();

}