package com.example.http_mvp_frame.jise;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
    //dddddd
}
