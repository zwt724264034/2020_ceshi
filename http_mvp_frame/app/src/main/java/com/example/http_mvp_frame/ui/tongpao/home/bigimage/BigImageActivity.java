package com.example.http_mvp_frame.ui.tongpao.home.bigimage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseActivity;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IBigImage;
import com.example.http_mvp_frame.persenter.tongpao.BigImagePersenter;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.viewpage.ViewpageAdapter;
import com.example.http_mvp_frame.utils.ImageLoader;
import com.example.http_mvp_frame.utils.TxtUtils;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BigImageActivity extends BaseActivity<BigImagePersenter> implements IBigImage.View {

    List<String> urls; //当前需要查看的所有图片的路径
    int currentPos; //当前操作的图片的位置
    @BindView(R.id.txt_return)
    TextView txtReturn;
    @BindView(R.id.txt_page)
    TextView txtPage;
    @BindView(R.id.txt_down)
    TextView txtDown;


    @Override
    protected int getLayout() {
        return R.layout.activity_bigimage;
    }

    @Override
    protected void inintView() {
        Intent intent = getIntent();
        //data存放图片数据和当前操作下标
        if (intent != null && intent.hasExtra("data")) {
            Bundle bundle = intent.getBundleExtra("data");
            if (bundle != null) {
                urls = bundle.getStringArrayList("urls");
                currentPos = bundle.getInt("postion");
//                updatePage();
            }
        }
        ViewPager vp = findViewById(R.id.vp);

        ViewpageAdapter viewpageAdapter = new ViewpageAdapter(urls, this);
        vp.setAdapter(viewpageAdapter);

        vp.setCurrentItem(currentPos);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txtPage.setText((position+1)+"/"+urls.size());
//                currentPos = position;
//                updatePage();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected BigImagePersenter cretePersenter() {
        return new BigImagePersenter(this);
    }

    @Override
    protected void inintData() {
        txtPage.setText((currentPos+1)+"/"+urls.size());
    }

    @OnClick({R.id.txt_return, R.id.txt_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_return:
                finish();
                break;
            case R.id.txt_down:
              //  downImg();
                break;
        }
    }

    //更新当前选中的图片位置
    private void updatePage() {
        if (currentPos < urls.size()) {
            String page = String.valueOf(currentPos / urls.size());
            TxtUtils.setTextView(txtPage, page);
            //判断是否有下载过
            String imgUrl = urls.get(currentPos);
            String[] arr = ImageLoader.splitUrl(imgUrl);
            String imgName = arr[1];
            String path = arr[2];
            File file = new File(path);
            if (file.exists()) {
                txtDown.setVisibility(View.GONE);
            } else {
                txtDown.setVisibility(View.VISIBLE);
            }
        } else {
            showToast("当前的图片位置越界", Toast.LENGTH_SHORT);
        }
    }

    private void downImg() {
        String imgUrl = urls.get(currentPos);
        persenter.downImg(imgUrl);
    }

    /**
     * 下载成功回调
     *
     * @param path
     */
    @Override
    public void downReturn(String path) {
        Log.i("TAG", path);
    }

    @Override
    public void showToast(String msg, int time) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
