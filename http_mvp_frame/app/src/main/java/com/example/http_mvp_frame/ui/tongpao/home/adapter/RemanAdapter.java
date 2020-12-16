package com.example.http_mvp_frame.ui.tongpao.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;

import java.util.ArrayList;
import java.util.List;

public class RemanAdapter extends RecyclerView.Adapter {
    Context context;
    List<Topic_DiscussedBean.DataBean> list;

    public RemanAdapter(Context context, List<Topic_DiscussedBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kaoshiview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Topic_DiscussedBean.DataBean dataBean = list.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
       // Glide .with(context).load(dataBean.getImageUrl()).into(viewHolder.img_huodong);
        Glide.with(context).load(dataBean.getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(15))).into(viewHolder.img_huodong);
        viewHolder.txt_wenzi1.setText(dataBean.getDepict());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_huodong;
        public TextView txt_wenzi1;
        public TextView tv_wenzi2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_huodong = (ImageView) rootView.findViewById(R.id.img_huodong);
            this.txt_wenzi1 = (TextView) rootView.findViewById(R.id.txt_wenzi1);
            this.tv_wenzi2 = (TextView) rootView.findViewById(R.id.tv_wenzi2);
        }

    }
}
