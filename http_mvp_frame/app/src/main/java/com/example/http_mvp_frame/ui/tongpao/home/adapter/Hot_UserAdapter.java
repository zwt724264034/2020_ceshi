package com.example.http_mvp_frame.ui.tongpao.home.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseAdapter;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;

import java.util.List;

public class Hot_UserAdapter extends BaseAdapter {

    private TextView hot_name;
    private TextView dress;
    private ImageView img1;
    private ImageView img2;
    private TextView focus;
    private ConstraintLayout cl2;
    private ImageView hot_head_img;
    private ConstraintLayout cl;
    private Context context;

    public Hot_UserAdapter(Context context, List<Hot_UserBean.DataBean> mData) {
        super(context, mData);
        this.context=context;
    }

    @Override
    protected int getLayout() {
        return R.layout.hot_user_view;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Hot_UserBean.DataBean bean = (Hot_UserBean.DataBean) data;
        hot_name = (TextView) vh.getViewById(R.id.hot_name);
        dress = (TextView) vh.getViewById(R.id.dress);
        img1= (ImageView) vh.getViewById(R.id.img1);
        img2 = (ImageView) vh.getViewById(R.id.img2);
        focus = (TextView) vh.getViewById(R.id.focus);
        cl2 = (ConstraintLayout) vh.getViewById(R.id.cl2);
        hot_head_img= (ImageView) vh.getViewById(R.id.hot_head_img);
        cl = (ConstraintLayout) vh.getViewById(R.id.cl);

        hot_name.setText(bean.getNickName());
        dress.setText(bean.getCity());
        Glide.with(context).load(bean.getHeadUrl()).apply(requestOptions).into(hot_head_img);
        Glide.with(context).load(bean.getFileBeanList().get(0).getFilePath()).into(img1);
        Glide.with(context).load(bean.getFileBeanList().get(1).getFilePath()).into(img2);

    }
}
