package com.example.http_mvp_frame.ui.easemob.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.http_mvp_frame.R;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessageBody;
import com.hyphenate.chat.EMTextMessageBody;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter {
    Context context;
    List<EMMessage> list;
    String user;

    public TextAdapter(Context context, List<EMMessage> list, String user) {
        this.context = context;
        this.list = list;
        this.user = user;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTo() == user) {
            return 1;
        } else {
            return 2;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.zuo, parent, false);
            ViewHolder1 holder1 = new ViewHolder1(inflate);
            return holder1;
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.you, parent, false);
            ViewHolder2 holder2 = new ViewHolder2(inflate);
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;

            EMMessage message = list.get(position);
            if (message.getType()== EMMessage.Type.TXT){
                viewHolder1.iv1.setVisibility(View.GONE);
                EMTextMessageBody body = (EMTextMessageBody) message.getBody();
                viewHolder1.t1.setText(body.getMessage());
            }else if (message.getType()==EMMessage.Type.IMAGE){
                viewHolder1.iv1.setVisibility(View.VISIBLE);
                EMImageMessageBody body = (EMImageMessageBody) message.getBody();
                //获取图片文件在服务器的路径
                String imgRemoteUrl = body.getRemoteUrl();
//获取图片缩略图在服务器的路径
                String thumbnailUrl = body.getThumbnailUrl();
//本地图片文件的资源路径
                Uri imgLocalUri = body.getLocalUri();
//本地图片缩略图资源路径
                Uri thumbnailLocalUri = body.thumbnailLocalUri();
                Glide.with(context).load(imgRemoteUrl).into(viewHolder1.iv1);

            }

        } else {
            EMMessage message = list.get(position);
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            if (message.getType()== EMMessage.Type.TXT){
                viewHolder2.iv2.setVisibility(View.GONE);
                EMTextMessageBody body = (EMTextMessageBody) message.getBody();
                viewHolder2.tv.setText(body.getMessage());
            }else if (message.getType()==EMMessage.Type.IMAGE){
                viewHolder2.iv2.setVisibility(View.VISIBLE);
                EMImageMessageBody body = (EMImageMessageBody) message.getBody();
                //获取图片文件在服务器的路径
                String imgRemoteUrl = body.getRemoteUrl();
//获取图片缩略图在服务器的路径
                String thumbnailUrl = body.getThumbnailUrl();
//本地图片文件的资源路径
                Uri imgLocalUri = body.getLocalUri();
//本地图片缩略图资源路径
                Uri thumbnailLocalUri = body.thumbnailLocalUri();
                Glide.with(context).load(imgLocalUri).into(viewHolder2.iv2);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView t1;
        public ImageView iv1;
        public ImageView iv2;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.t1 = (TextView) rootView.findViewById(R.id.txt_word);
            this.iv1 = rootView.findViewById(R.id.img_icon);
            this.iv2 = rootView.findViewById(R.id.img_header);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv;
        public ImageView iv1;
        public ImageView iv2;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.txt_word);
            this.iv1 =  rootView.findViewById(R.id.img_header);
            this.iv2 =  rootView.findViewById(R.id.img_icon);
        }

    }

//dddddd
}
