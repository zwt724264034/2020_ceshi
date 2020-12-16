package com.example.http_mvp_frame.persenter.tongpao;

import com.example.http_mvp_frame.base.BasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IBigImage;
import com.example.http_mvp_frame.module.tongpaomodel.BigImageModel;

public class BigImagePersenter extends BasePersenter<IBigImage.View> implements IBigImage.Persenter {

    IBigImage.View view;
    //接口的规范是DownModel mode
    BigImageModel model;
    public BigImagePersenter(IBigImage.View view){
        this.view = view;
        model = new BigImageModel();
    }
    @Override
    public void downImg(String url) {
        model.downImage(url, new Callback() {
            @Override
            public void fail(String msg) {

            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.downReturn((String) o);
                }
            }
        });
    }
    @Override
    public void unAttachView() {
        super.unAttachView();
        if(model != null){
            model.clear();
            model = null;
        }
    }
}
