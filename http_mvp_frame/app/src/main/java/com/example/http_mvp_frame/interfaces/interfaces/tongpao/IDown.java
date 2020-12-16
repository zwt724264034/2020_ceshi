package com.example.http_mvp_frame.interfaces.interfaces.tongpao;

import com.example.http_mvp_frame.interfaces.interfaces.Callback;

/**
 * 提供给所有的业务使用的公共接口
 */
public interface IDown {

    interface DownModel {
        void downImage(String url, Callback callback);
    }
}
