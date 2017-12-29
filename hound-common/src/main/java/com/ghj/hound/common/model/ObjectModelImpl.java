package com.ghj.hound.common.model;

public class ObjectModelImpl<T> implements ObjectModel<T> {

    private T obj = null;

    @Override
    public T getObj() {
        return obj;
    }

    @Override
    public Model setObj(T obj) {
        this.obj = obj;
        return this;
    }
}
