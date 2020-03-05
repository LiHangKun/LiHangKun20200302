package com.bawei.lihangkun20200302.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.lihangkun20200302.R;
import com.bawei.lihangkun20200302.adapter.MyAdapterFour;
import com.bawei.lihangkun20200302.adapter.MyAdapterOne;
import com.bawei.lihangkun20200302.adapter.MyAdapterThree;
import com.bawei.lihangkun20200302.adapter.MyAdapterTwo;
import com.bawei.lihangkun20200302.base.BaseActivity;
import com.bawei.lihangkun20200302.base.BasePresenter;
import com.bawei.lihangkun20200302.bean.BeanClass;
import com.bawei.lihangkun20200302.bean.BeanClassTwo;
import com.bawei.lihangkun20200302.contral.IHomePageContral;
import com.bawei.lihangkun20200302.presenter.HomePagePresenter;
import com.bawei.lihangkun20200302.util.VolleyUtiles;
import com.bawei.lihangkun20200302.zidingyi.CustomViewGroup;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity implements IHomePageContral.getView {


    private RecyclerView re;
    private List<BeanClass.DataBean.HorizontalListDataBean> horizontalListData;
    private RecyclerView retwo;
    private List<BeanClass.DataBean.VerticalListDataBean> verticalListData;
    private RecyclerView rethree;
    private List<BeanClass.DataBean.GridDataBean> gridData;
    private CustomViewGroup gp;
    private BasePresenter presenter;
    private RecyclerView refour;

    @Override
    protected void initData() {
        String a="http://blog.zhaoliang5156.cn/api/shop/jingdong.json";
        presenter = getPresenter();
        if(presenter !=null && presenter instanceof HomePagePresenter){
            ((HomePagePresenter) presenter).getReJson(a);
        }
        gp.setOnClickListener(new CustomViewGroup.OnClick() {
            @Override
            public void click(String str) {
                String a="http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword";
                a=a+"?keyword="+str+"&page=1"+"&count=5";
                BasePresenter presenter = getPresenter();

                if(presenter !=null && presenter instanceof HomePagePresenter){
                    ((HomePagePresenter) MainActivity.this.presenter).getSouJson(a);
                }
                Log.i("json",str+"");
                Toast.makeText(MainActivity.this, ""+str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initView() {
        re = findViewById(R.id.re);
        retwo = findViewById(R.id.retwo);
        rethree = findViewById(R.id.rethree);
        gp = findViewById(R.id.gp);
        refour = findViewById(R.id.refour);
    }


    @Override
    protected BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected int getLayout() {
        boolean netWork = VolleyUtiles.getInstance().getNetWork(this);
        if(true){
            return R.layout.activity_main;
        }else{
            return R.layout.activitytwo;
        }
    }

    @Override
    public void getReSuccess(String json) {
        Log.i("xxx",json+"");
        Gson gson = new Gson();
        BeanClass beanClass = gson.fromJson(json, BeanClass.class);
        BeanClass.DataBean data = beanClass.getData();
        gridData = data.getGridData();
        horizontalListData = data.getHorizontalListData();
        verticalListData = data.getVerticalListData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        re.setLayoutManager(linearLayoutManager);
        MyAdapterOne myAdapterOne = new MyAdapterOne(this, horizontalListData);
        re.setAdapter(myAdapterOne);
        myAdapterOne.setOnclickListener(new MyAdapterOne.OnClickListener() {
            @Override
            public void click(int position) {
                Log.i("www",position+"");
                Toast.makeText(MainActivity.this, "点击了img"+position, Toast.LENGTH_SHORT).show();
            }
        });
        //条目二
        LinearLayoutManager ltwo = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        retwo.setLayoutManager(ltwo);
        MyAdapterTwo myAdapterTwo = new MyAdapterTwo(this, verticalListData);
        retwo.setAdapter(myAdapterTwo);
        myAdapterTwo.setOnClick(new MyAdapterTwo.setOnClickItem() {
            @Override
            public void click(int postion) {
                BeanClass.DataBean.VerticalListDataBean verticalListDataBean = verticalListData.get(postion);
                String title = verticalListDataBean.getTitle();
                Toast.makeText(MainActivity.this, ""+title, Toast.LENGTH_SHORT).show();
            }
        });

        //条目三
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rethree.setLayoutManager(gridLayoutManager);
        MyAdapterThree myAdapterThree = new MyAdapterThree(this, gridData);
        rethree.setAdapter(myAdapterThree);
        myAdapterThree.setOnClick(new MyAdapterThree.setOnClickItem() {
            @Override
            public void click(int postion) {
                BeanClass.DataBean.GridDataBean gridDataBean = gridData.get(postion);
                String title = gridDataBean.getTitle();
                Toast.makeText(MainActivity.this, ""+title, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void getReFaiuld(String json) {

    }

    @Override
    public void souSuccess(String json) {
        Log.i("json",json+"");
        Gson gson = new Gson();
        BeanClassTwo beanClassTwo = gson.fromJson(json, BeanClassTwo.class);

        List<BeanClassTwo.ResultBean> result = beanClassTwo.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        refour.setLayoutManager(gridLayoutManager);
        MyAdapterFour myAdapterFour = new MyAdapterFour(this, result);
        refour.setAdapter(myAdapterFour);
    }

    @Override
    public void souFaiuld(String json) {

    }
}
