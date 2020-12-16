package com.example.http_mvp_frame.net;

import android.text.TextUtils;

import com.example.http_mvp_frame.interfaces.interfaces.Callback;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * 处理网络请求结果的错误和完成
 */
public abstract class CommonSubscriber <T>extends ResourceSubscriber<T> {
    private Callback callback;
    private String errorMsg;
    private boolean isShowErrorState = false;

    protected CommonSubscriber(Callback callback) {
        this.callback = callback;
    }

    protected CommonSubscriber(Callback callback, String emsg) {
        this.callback = callback;
        errorMsg = emsg;
    }

    @Override
    public void onError(Throwable t) {
        if (callback==null)return;
        if (errorMsg!=null&& TextUtils.isEmpty(errorMsg)){
            callback.fail(errorMsg);
        }
    }

    @Override
    public void onComplete() {

    }
}
