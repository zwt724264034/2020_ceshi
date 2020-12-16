package com.example.http_mvp_frame.interfaces.interfaces.tongpao;

import com.example.http_mvp_frame.interfaces.interfaces.IBasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.IBaseView;
import com.example.http_mvp_frame.interfaces.interfaces.IModel;

public interface IBigImage {

    interface View extends IBaseView {

        void downReturn(String path);

    }
    interface Persenter extends IBasePersenter<View>{
        void downImg(String url);
    }
    interface Model extends IModel{
        void getBigImage();
    }
}
