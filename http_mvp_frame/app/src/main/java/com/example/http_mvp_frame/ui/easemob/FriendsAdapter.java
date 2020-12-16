package com.example.http_mvp_frame.ui.easemob;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseAdapter;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    Context context;
    public FriendsAdapter(Context context, List<String> list){
        super(context,list);
        this.context=context;
    }
    @Override
    protected int getLayout() {
        return R.layout.layout_friend_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        TextView txtUserName = (TextView) vh.getViewById(R.id.txt_username);
        ImageView iv_userhead = (ImageView) vh.getViewById(R.id.iv_userhead);
        Glide.with(context).load(R.mipmap.ic_launcher).apply(requestOptions).into(iv_userhead);
        txtUserName.setText(data.toString());
        Button btnOpenDetail = (Button) vh.getViewById(R.id.btn_openUserDetail);
        btnOpenDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iItemViewClick != null){
                    iItemViewClick.itemViewClick(v.getId(),data);
                }
            }
        });
    }
}
