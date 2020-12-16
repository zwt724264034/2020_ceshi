package com.example.http_mvp_frame.module.data.shop;

import com.example.http_mvp_frame.base.BaseModel;
import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.shop.IShopContract;
import com.example.http_mvp_frame.net.CommonSubscriber;
import com.example.http_mvp_frame.net.HttpManager;
import com.example.http_mvp_frame.utils.RxUtils;

public class ShopModel extends BaseModel implements IShopContract.Model {

    @Override
    public void getShop(Callback callback) {
        addDisposable(
                HttpManager.getInstance().getShopapi().getShop()
                        .compose(RxUtils.<ShopBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<ShopBean>(callback) {
                            @Override
                            public void onNext(ShopBean shopBean) {
                                callback.success(shopBean);
                            }
                        })
        );
    }
}
