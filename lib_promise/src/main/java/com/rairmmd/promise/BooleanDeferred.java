package com.rairmmd.promise;

public class BooleanDeferred extends Deferred<Boolean> implements BooleanPromise {

    private BooleanDeferred() {
    }

    public static BooleanDeferred newDeferred() {
        return new BooleanDeferred();
    }

    @Override
    public BooleanPromise ifTrueThen(Runnable runnable) {
        then(commandForTrue(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifTrueThenOnMainThread(Runnable runnable) {
        thenOnMainThread(commandForTrue(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifTrueThenOnBackgroundThread(Runnable runnable) {
        thenOnBackgroundThread(commandForTrue(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifTrueThenAsync(Runnable runnable) {
        thenAsync(commandForTrue(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifFalseThen(final Runnable runnable) {
        then(commandForFalse(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifFalseThenOnMainThread(Runnable runnable) {
        thenOnMainThread(commandForFalse(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifFalseThenOnBackgroundThread(Runnable runnable) {
        thenOnBackgroundThread(commandForFalse(runnable));
        return this;
    }

    @Override
    public BooleanPromise ifFalseThenAsync(Runnable runnable) {
        thenAsync(commandForFalse(runnable));
        return this;
    }

    private Task<Boolean> commandForTrue(final Runnable runnable) {
        return new Task<Boolean>() {
            @Override
            public void run(Boolean bool) {
                if (bool) {
                    runnable.run();
                }
            }
        };
    }

    private Task<Boolean> commandForFalse(final Runnable runnable) {
        return new Task<Boolean>() {
            @Override
            public void run(Boolean bool) {
                if (!bool) {
                    runnable.run();
                }
            }
        };
    }
}