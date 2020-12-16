package com.example.http_mvp_frame.base;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.http_mvp_frame.interfaces.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements IBaseView {

    //P层关联
    protected P persenter;
    //butterknife
    Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //需要界面View
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        inintView();
        persenter = cretePersenter();
        if (persenter != null) {
            persenter.attachView(this);
        }
        //初始化界面数据
        inintData();

    }

    //定义一个获取当前界面的方法，由子类提供的
    protected abstract int getLayout();

    //初始化界面
    protected abstract void inintView();

    //初始化P层的方法
    protected abstract P cretePersenter();

    //c初始化界面数据

    protected abstract void inintData();

    @Override
    public void tips(String tip) {
        Log.e("TAG", "tips: " + tip);
    }

    @Override
    public void loading(int visible) {

    }
    @Override
    public void showToast(String msg,int time){
        Toast.makeText(this, msg, time).show();
    }

    /**
     * 界面销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        //释放P关联的V的引用
        if (persenter != null) {
            persenter.unAttachView();
        }
    }
}