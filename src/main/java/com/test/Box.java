package com.test;

public interface Box<T> {
    public T get();

    public void put(T element);
}