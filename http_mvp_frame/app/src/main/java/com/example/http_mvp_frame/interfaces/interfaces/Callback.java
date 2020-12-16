package com.example.http_mvp_frame.interfaces.interfaces;

public interface Callback<T> {
    void fail(String msg);
    void success(T t);
}
