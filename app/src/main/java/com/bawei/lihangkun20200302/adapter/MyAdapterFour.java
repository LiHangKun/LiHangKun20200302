package com.bawei.lihangkun20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lihangkun20200302.R;
import com.bawei.lihangkun20200302.activity.MainActivity;
import com.bawei.lihangkun20200302.bean.BeanClassTwo;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapterFour extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<BeanClassTwo.ResultBean> result;

    public MyAdapterFour(Context context, List<BeanClassTwo.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.itemfour, null);
        ViewHolderOne viewHolderOne = new ViewHolderOne(view);
        return viewHolderOne;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BeanClassTwo.ResultBean resultBean = result.get(i);
        String commodityName = resultBean.getCommodityName();
        String masterPic = resultBean.getMasterPic();
        ((ViewHolderOne)viewHolder).tx.setText(commodityName+"");
        Glide.with(context).load(masterPic).into(((ViewHolderOne)viewHolder).img);

    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    public class ViewHolderOne extends RecyclerView.ViewHolder{

        private final TextView tx;
        private final ImageView img;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tx = itemView.findViewById(R.id.tx);
        }
    }
}
