package com.bawei.lihangkun20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.lihangkun20200302.R;
import com.bawei.lihangkun20200302.activity.MainActivity;
import com.bawei.lihangkun20200302.bean.BeanClass;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapterTwo extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<BeanClass.DataBean.VerticalListDataBean> verticalListData;

    public MyAdapterTwo(Context context, List<BeanClass.DataBean.VerticalListDataBean> verticalListData) {
        this.context = context;
        this.verticalListData = verticalListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.itwmtwo, null);
        ViewHolderOne viewHolderOne = new ViewHolderOne(inflate);
        return viewHolderOne;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String title = verticalListData.get(i).getTitle();
        String price = verticalListData.get(i).getPrice();
        String imageurl = verticalListData.get(i).getImageurl();
        ((ViewHolderOne)viewHolder).tx1.setText(title+"");
        ((ViewHolderOne)viewHolder).tx2.setText(price+"");
        Glide.with(context).load(imageurl).into(((ViewHolderOne)viewHolder).img);
        ((ViewHolderOne)viewHolder).lintwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(msetOnClickItem!=null){
                        msetOnClickItem.click(i);
                }
            }
        });
    }
    setOnClickItem msetOnClickItem;
    public void setOnClick(setOnClickItem setOnClickItem){
        msetOnClickItem=setOnClickItem;
    }
    public interface setOnClickItem{
        void click(int postion);
    }
    @Override
    public int getItemCount() {

        return verticalListData.size();
    }
    public class ViewHolderOne extends RecyclerView.ViewHolder{


        private final TextView tx1;
        private final TextView tx2;
        private final ImageView img;
        private final LinearLayout lintwo;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tx1 = itemView.findViewById(R.id.tx1);
            tx2 = itemView.findViewById(R.id.tx2);
            img = itemView.findViewById(R.id.img);
            lintwo = itemView.findViewById(R.id.lintwo);
        }
    }

}
