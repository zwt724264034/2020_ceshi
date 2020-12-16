package com.example.http_mvp_frame.persenter.shop;

import com.example.http_mvp_frame.base.BasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.shop.IShopContract;
import com.example.http_mvp_frame.module.data.shop.ShopBean;
import com.example.http_mvp_frame.module.data.shop.ShopModel;


public class ShopPersenter extends BasePersenter<IShopContract.View> implements  IShopContract.Persenter {
    IShopContract.View view;
    IShopContract.Model model;
    public ShopPersenter(IShopContract.View view) {
        this.view = view;
        this.model=new ShopModel();
    }

    @Override
    public void getShop() {
        this.model.getShop(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getShop((ShopBean) o);
                }
            }
        });
    }
}
