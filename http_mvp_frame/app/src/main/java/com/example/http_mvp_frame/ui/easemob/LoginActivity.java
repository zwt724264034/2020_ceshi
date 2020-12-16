package com.example.http_mvp_frame.ui.easemob;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.http_mvp_frame.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText paw;
    private Button bt;
    private ArrayList<String> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        paw = (EditText) findViewById(R.id.paw);
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(this);
        userList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                String name = this.name.getText().toString();
                String paw = this.paw.getText().toString();

                EMClient.getInstance().login(name, paw, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        Log.i("TAG", "登录成功");
                        getFriends();
                    }

                    @Override
                    public void onError(int code, String error) {
                        Log.i("TAG", "onError:" + error);
                    }

                    @Override
                    public void onProgress(int progress, String status) {
                        Log.i("TAG", "status:" + status);
                    }
                });

                break;
        }
    }

    /**
     * 获取好友
     */
    private void getFriends() {
        try {
            List<String> friends = EMClient.getInstance().contactManager().getAllContactsFromServer();
            userList.clear();
            if (friends != null) {
                for (int i = 0; i < friends.size(); i++) {
                    Log.e("TAG", "getFriends: " + friends.get(i));
                    userList.add(friends.get(i));
                }
                Intent intent = new Intent(LoginActivity.this, EaseMobActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list", userList);
                intent.putExtra("list",bundle);
                startActivity(intent);
            }
        } catch (HyphenateException e) {
            e.printStackTrace();
        }

    }
}