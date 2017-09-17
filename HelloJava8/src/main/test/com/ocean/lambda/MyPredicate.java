package com.ocean.lambda;

/**
 * Created by spring on 2017/9/10.
 */
@FunctionalInterface
public interface MyPredicate<T> {
    public boolean filterEmployee(T t);
}
