package com.bawei.lihangkun20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.lihangkun20200302.R;
import com.bawei.lihangkun20200302.activity.MainActivity;
import com.bawei.lihangkun20200302.bean.BeanClass;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import java.util.List;

public class MyAdapterOne extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<BeanClass.DataBean.HorizontalListDataBean> horizontalListData;
    private OnClickListener onClickListener;

    public MyAdapterOne(Context context, List<BeanClass.DataBean.HorizontalListDataBean> horizontalListData) {
        this.context = context;
        this.horizontalListData = horizontalListData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.itemone, null);
        ViewHolderOne viewHolderOne = new ViewHolderOne(inflate);
        return viewHolderOne;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String imageurl = horizontalListData.get(i).getImageurl();
        Glide.with(context).load(imageurl).priority(Priority.HIGH).into(((ViewHolderOne)viewHolder).img);
        ((ViewHolderOne)viewHolder).lione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monClickListener!=null){
                    monClickListener.click(i);
                }
            }
        });
    }
     private OnClickListener monClickListener;
    public void setOnclickListener(OnClickListener onclickListener){
        monClickListener=onClickListener;
    }
    public interface OnClickListener{
        void click(int position);
    }
    @Override
    public int getItemCount() {

        return horizontalListData.size();
    }
    public class ViewHolderOne extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final LinearLayout lione;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            lione = itemView.findViewById(R.id.lione);
        }
    }

}
