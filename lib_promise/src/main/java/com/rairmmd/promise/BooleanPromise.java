package com.rairmmd.promise;

public interface BooleanPromise extends Promise<Boolean> {

    BooleanPromise ifTrueThen(Runnable runnable);

    BooleanPromise ifTrueThenOnMainThread(Runnable runnable);

    BooleanPromise ifTrueThenOnBackgroundThread(Runnable runnable);

    BooleanPromise ifTrueThenAsync(Runnable runnable);

    BooleanPromise ifFalseThen(Runnable runnable);

    BooleanPromise ifFalseThenOnMainThread(Runnable runnable);

    BooleanPromise ifFalseThenOnBackgroundThread(Runnable runnable);

    BooleanPromise ifFalseThenAsync(Runnable runnable);

}