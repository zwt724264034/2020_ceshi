package com.example.http_mvp_frame.ui.tongpao.home.adapter.person;

import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseAdapter;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    Context context;
    private ImageView iv_personal_heder;
    private TextView tv_username;
    private Button bt_personal_attention;
    private Button bt_personal_liaota;
    private TextView tv_personal_gexingqianming;
    private TextView tv_user_attention;
    private TextView tv_user_fans;
    private TextView tv_user_experience;

    public PersonAdapter(Context context, List<PersonDataBean.DataBean> mData) {
        super(context, mData);
        this.context = context;
    }

    @Override
    protected int getLayout() {
        return R.layout.person_view;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        PersonDataBean.DataBean bean = (PersonDataBean.DataBean) data;

        iv_personal_heder = (ImageView) vh.getViewById(R.id.iv_personal_heder);
        tv_username = (TextView) vh.getViewById(R.id.tv_username);
        bt_personal_attention = (Button) vh.getViewById(R.id.bt_personal_attention);
        bt_personal_liaota = (Button) vh.getViewById(R.id.bt_personal_liaota);
        tv_personal_gexingqianming = (TextView) vh.getViewById(R.id.tv_personal_gexingqianming);
        tv_user_attention = (TextView) vh.getViewById(R.id.tv_user_attention);
        tv_user_fans = (TextView) vh.getViewById(R.id.tv_user_fans);
        tv_user_experience = (TextView) vh.getViewById(R.id.tv_user_experience);

        Glide.with(context).load(bean.getHeadUrl()).apply(requestOptions).into(iv_personal_heder);
        tv_username.setText(bean.getNickName());
        tv_personal_gexingqianming.setText(bean.getSignature());
        tv_user_attention.setText(bean.getRewardnumber()+"");
        tv_user_fans.setText(bean.getArticelnumber()+"");
        tv_user_experience.setText(bean.getContactMe()+"");

    }
}
