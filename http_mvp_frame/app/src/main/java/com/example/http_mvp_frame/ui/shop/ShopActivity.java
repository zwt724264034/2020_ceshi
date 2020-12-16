package com.example.http_mvp_frame.ui.shop;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseActivity;
import com.example.http_mvp_frame.interfaces.interfaces.shop.IShopContract;
import com.example.http_mvp_frame.module.data.shop.ShopBean;
import com.example.http_mvp_frame.persenter.shop.ShopPersenter;

public class ShopActivity extends BaseActivity<ShopPersenter>implements IShopContract.View {

    @Override
    protected int getLayout() {
        return R.layout.activity_shop;
    }

    @Override
    protected void inintView() {

    }

    @Override
    protected ShopPersenter cretePersenter() {
        return new ShopPersenter(this);
    }

    @Override
    protected void inintData() {
        persenter.getShop();
    }

    @Override
    public void getShop(ShopBean shopBean) {
        Log.d("tag", ""+shopBean.toString());
    }
}
