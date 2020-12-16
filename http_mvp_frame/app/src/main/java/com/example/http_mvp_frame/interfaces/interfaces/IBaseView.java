package com.example.http_mvp_frame.interfaces.interfaces;

public interface IBaseView {
    void tips(String tip);

    void loading(int visible);

    void showToast(String msg, int time);
}
