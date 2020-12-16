package com.example.http_mvp_frame.ui.tongpao.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.ViewPaferAdapter;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.ArticleFragment;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.PhotographyFragment;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.RecommendFragment;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.SquareFragment;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.VideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TongpaoActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private ViewPaferAdapter viewPaferAdapter;
    String[] tabs = {"推荐","广场","视频","摄影","知识文章"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongpao);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(new RecommendFragment());
        fragments.add(new ArticleFragment());
        fragments.add(new PhotographyFragment());
        fragments.add(new VideoFragment());
        fragments.add(new SquareFragment());
        //Tablayou横向滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //初始化Viewpager
        viewPaferAdapter = new ViewPaferAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPaferAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
