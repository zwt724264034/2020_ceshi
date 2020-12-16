package com.example.http_mvp_frame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.http_mvp_frame.ui.baiduditu.BaiduActivity;
import com.example.http_mvp_frame.ui.easemob.LoginActivity;
import com.example.http_mvp_frame.ui.tongpao.home.TongpaoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_tongpao;
    private Button baidu_bt;
    private Button bthuanxin;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_tongpao = (Button) findViewById(R.id.bt_tongpao);
        baidu_bt = (Button) findViewById(R.id.baidu_bt);
        bthuanxin = (Button) findViewById(R.id.bt_huanxin);


        bt_tongpao.setOnClickListener(this);
        baidu_bt.setOnClickListener(this);
        bthuanxin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_tongpao:
                intent = new Intent(this, TongpaoActivity.class);
                startActivity(intent);
                break;
            case R.id.baidu_bt:
                intent = new Intent(this, BaiduActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_huanxin:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}