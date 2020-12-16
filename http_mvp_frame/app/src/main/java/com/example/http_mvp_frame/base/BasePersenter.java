package com.example.http_mvp_frame.base;

import com.example.http_mvp_frame.interfaces.interfaces.IBasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.IBaseView;

import java.lang.ref.WeakReference;

/**
 * P层的基类
 *
 * @param <V>
 */
public class BasePersenter<V extends IBaseView> implements IBasePersenter<V> {
    protected V mview;
    //通过弱引用把V层关联
    WeakReference<V> weakReference;

    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
        mview = weakReference.get();
    }

    @Override
    public void unAttachView() {
        mview = null;
    }
}
