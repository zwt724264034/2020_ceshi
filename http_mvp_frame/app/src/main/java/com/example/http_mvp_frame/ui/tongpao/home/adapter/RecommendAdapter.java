package com.example.http_mvp_frame.ui.tongpao.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseAdapter;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.ui.tongpao.home.PersonActivity;
import com.example.http_mvp_frame.ui.tongpao.home.bigimage.BigImageActivity;
import com.example.http_mvp_frame.utils.TxtUtils;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.carbs.android.expandabletextview.library.ExpandableTextView;

public class RecommendAdapter extends BaseAdapter {

    Context context;
    ImageView ivHeadPortrait;
    RecyclerView rcy;
    TextView tvUsername;
    Button btAttention;
    ExpandableTextView tvParticulars;
    NineGridImageView nineGrid;
    TextView tvData;

    public RecommendAdapter(Context context, List<RecommendBean.DataBean> mData) {
        super(context, mData);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_recommend_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        RecommendBean.DataBean bean = (RecommendBean.DataBean) data;
        tvData = (TextView) vh.getViewById(R.id.tv_data);
        nineGrid = (NineGridImageView) vh.getViewById(R.id.nineGrid);
        tvParticulars = (ExpandableTextView) vh.getViewById(R.id.tv_particulars);
        btAttention = (Button) vh.getViewById(R.id.bt_attention);
        tvUsername = (TextView) vh.getViewById(R.id.tv_username);
        ivHeadPortrait = (ImageView) vh.getViewById(R.id.iv_head_portrait);
        TxtUtils.setTextView(tvUsername, bean.getPostDetail().getNickName());

        ivHeadPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PersonActivity.class));
            }
        });

        tvData.setText(bean.getPostDetail().getCreateTime());
        tvParticulars.setText(bean.getPostDetail().getContent());
        Glide.with(context).load(bean.getPostDetail().getHeadUrl()).apply(requestOptions).into(ivHeadPortrait);
        testSpanAbleString(tvParticulars, bean.getPostDetail().getContent());

        ArrayList<String> imgs = new ArrayList<>();
        for (RecommendBean.DataBean.PostDetailBean.ImagesBean item : bean.getPostDetail().getImages()) {
            imgs.add(item.getFilePath());
        }
        nineGrid.setAdapter(new NineGridImageViewAdapter() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, Object o) {
                RecommendBean.DataBean.PostDetailBean.ImagesBean img= (RecommendBean.DataBean.PostDetailBean.ImagesBean) o;
                Glide.with(context).load(img.getFilePath()).into(imageView);
            }

            @Override
            protected void onItemImageClick(Context context, int index, List list) {
                super.onItemImageClick(context, index, list);
                Intent intent = new Intent(context, BigImageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("postion",index);
                bundle.putStringArrayList("urls",imgs);
                intent.putExtra("data",bundle);
                context.startActivity(intent);
            }
        });
        nineGrid.setImagesData(bean.getPostDetail().getImages());
    }
    public void testSpanAbleString(TextView textView, String content) {
        SpannableString spannable = new SpannableString(content);
//        int startIndex = content.indexOf("#");
//        int endIndex = content.lastIndexOf("#")+1;
        spannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(context, "" + widget, Toast.LENGTH_SHORT).show();
            }
        };
        textView.setText(spannable);

    }
}
