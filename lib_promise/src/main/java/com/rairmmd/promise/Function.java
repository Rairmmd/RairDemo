package com.rairmmd.promise;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class Function<T> {

    static boolean sync;
    private static Executable executable = new Executable(new AsyncTaskExecutor());

    public static void setExecutor(Executor executor) {
        executable = new Executable(executor);
    }

    public static void enableAlwaysSyncCalls() {
        sync = true;
    }

    public static void disableAlwaysSyncCalls() {
        sync = false;
    }

    public static <T> Promise<T> execute(final Callable<T> callable) {
        if (sync) {
            return executeSync(callable);
        } else {
            return executable.execute(callable);
        }
    }

    public static <T> Promise<T> execute(final PromiseCallable<T> callable) {
        if (sync) {
            return executeSync(callable);
        } else {
            return executable.execute(callable);
        }
    }

    public static Executable on(Executor executor) {
        return new Executable(executor);
    }

    public static <T> Promise<T> executeSync(Callable<T> callable) {
        Deferred<T> deferred = Deferred.newDeferred();
        try {
            deferred.resolve(callable.call());
        } catch (Throwable throwable) {
            deferred.reject(throwable);
        }
        return deferred;
    }

    public static <T> Promise<T> executeSync(PromiseCallable<T> callable) {
        return callable.call();
    }

}
