package com.bawei.lihangkun20200302.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseIvew{
    P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPresenter=initPresenter();
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();
    public P getPresenter(){
        return mPresenter;
    }

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.dechView();
            mPresenter=null;
        }
    }
}
