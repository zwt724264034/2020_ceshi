package com.example.http_mvp_frame.interfaces.interfaces;

public interface IBasePersenter<V extends IBaseView> {
    void  attachView(V view);
    void unAttachView();
}
