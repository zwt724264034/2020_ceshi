package com.example.http_mvp_frame.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.http_mvp_frame.interfaces.interfaces.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePersenter> extends Fragment implements IBaseView {
    protected P persenter;
    Unbinder unbinder;
    protected Context mContext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(getLayout(), null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext =getContext();
        unbinder = ButterKnife.bind(this, view);

        persenter = createPersenter();
        if(persenter != null){
            persenter.attachView(this);
        }
        inintView();
        inintData();
    }

    public abstract int getLayout();

    public abstract void inintView();

    public abstract P createPersenter();

    public abstract void inintData();

    @Override
    public void tips(String tip) {

    }

    @Override
    public void loading(int visible) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (persenter != null) {
            persenter.unAttachView();
        }
    }
}
