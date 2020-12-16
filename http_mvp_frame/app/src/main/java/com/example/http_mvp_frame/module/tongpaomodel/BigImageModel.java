package com.example.http_mvp_frame.module.tongpaomodel;

import com.example.http_mvp_frame.app.Constants;
import com.example.http_mvp_frame.base.BaseModel;
import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IBigImage;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IDown;
import com.example.http_mvp_frame.net.CommonSubscriber;
import com.example.http_mvp_frame.net.HttpManager;
import com.example.http_mvp_frame.utils.ImageLoader;
import com.example.http_mvp_frame.utils.RxUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class BigImageModel extends BaseModel implements IBigImage.Model, IDown.DownModel{
    /**
     * 下载图片
     */


    @Override
    public void downImage(String url, Callback callback) {
        String[] arr = ImageLoader.splitUrl(url);
        String baseUrl = arr[0];
        String imgName = arr[1];
        String path = arr[2];
        Disposable disposable = HttpManager.getInstance().getImageApi(baseUrl)
                .downImage(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ResponseBody>(callback) {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        InputStream inputStream = responseBody.byteStream();
                        FileOutputStream fileOutputStream = null;
                        //拿到流写入本地
                        try {
                            //判断当前的流是否有数据
                            if(inputStream.available() > 0){
                                //判断当前本地的路径是否存在
                                File file = new File(Constants.PATH_IMGS);
                                if(file.isDirectory() && !file.exists()){
                                    boolean bool = file.createNewFile();
                                    if(bool){
                                        fileOutputStream = new FileOutputStream(path);
                                        int n = 0;
                                        byte[] bytes = new byte[4096];
                                        while((n=inputStream.read(bytes)) != -1){
                                            fileOutputStream.write(bytes);
                                        }
                                        fileOutputStream.flush(); //刷新到sd卡
                                    }else{
                                        callback.fail("创建本地目录失败");
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            try {
                                inputStream.close();
                                fileOutputStream.close();
                                callback.success(path);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
        addDisposable(disposable);

    }
    @Override
    public void getBigImage() {

    }
}
