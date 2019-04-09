package com.rairmmd.promise;

public interface Converter<T, V> {

    V transform(T value);

}