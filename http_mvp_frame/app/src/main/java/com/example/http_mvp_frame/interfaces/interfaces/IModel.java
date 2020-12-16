package com.example.http_mvp_frame.interfaces.interfaces;

import io.reactivex.disposables.Disposable;

public interface IModel {

    void addDisposable(Disposable disposable);

    void clear();
}
