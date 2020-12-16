package com.example.http_mvp_frame.ui.tongpao.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseAdapter;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.utils.TxtUtils;


import java.util.List;

public class DiscussedAdapter extends BaseAdapter {
    Context context;
    public DiscussedAdapter(Context context, List<Topic_DiscussedBean.DataBean> mData) {
        super(context,mData);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_dicussed_item ;
    }
    @Override
    protected void bindData(Object data, VH vh) {
        Topic_DiscussedBean.DataBean dataBean = (Topic_DiscussedBean.DataBean) data;
        ImageView imgIcon = (ImageView) vh.getViewById(R.id.img_icon);
        TextView txt_tags = (TextView) vh.getViewById(R.id.txt_tags);
        TextView tv_cy = (TextView) vh.getViewById(R.id.tv_cy);
        TxtUtils.setTextView(txt_tags,"#"+dataBean.getName()+"#");
        TxtUtils.setTextView(tv_cy,dataBean.getUseTime()+"人参与");
        Glide.with(context).load(dataBean.getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(15))).into(imgIcon);
    }
}
