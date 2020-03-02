package com.bawei.lihangkun20200302.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseIvew> implements BaseIvew{
    WeakReference<V> mWeakReference;
    public BasePresenter(V v){
        mWeakReference=new WeakReference<>(v);
        initModel();
    }

    public V getView(){
        if(mWeakReference!=null){
                    return mWeakReference.get();
        }
        return null;
    }
    public void dechView(){
        if(mWeakReference!=null){
            mWeakReference.clear();
        }
        mWeakReference=null;
    }

    protected abstract void initModel();
}
