package com.example.http_mvp_frame.ui.easemob;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseAdapter;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.List;

public class EaseMobActivity extends AppCompatActivity{

    private static final String TAG = EaseMobActivity.class.getSimpleName();

    RecyclerView recyUserList;
    FriendsAdapter friendsAdapter;
    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ease_mob);
        recyUserList = findViewById(R.id.recy_userList);
        initUserList();
    }

    private void initUserList() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("list");
        ArrayList<String> list1 = bundle.getStringArrayList("list");

        friendsAdapter = new FriendsAdapter(this,list1);
        recyUserList.setLayoutManager(new LinearLayoutManager(this));
        recyUserList.setAdapter(friendsAdapter);
        recyUserList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        friendsAdapter.notifyDataSetChanged();
        friendsAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                String userid = list1.get(pos);
                Intent intent = new Intent(EaseMobActivity.this,ChatActivity.class);
                intent.putExtra("touserid",list1.get(pos));
                startActivity(intent);
            }
        });
    }


}
