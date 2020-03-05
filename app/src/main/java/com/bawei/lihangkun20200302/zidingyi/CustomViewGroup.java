package com.bawei.lihangkun20200302.zidingyi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.lihangkun20200302.R;

public class CustomViewGroup extends LinearLayout {

    private CustomStystemView soutxone;
    private TextView soutxtwo;

    public CustomViewGroup(Context context) {
        super(context);
        init(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.sousuo, null);
        soutxone = view.findViewById(R.id.soutxone);
        soutxtwo = view.findViewById(R.id.soutxtwo);
        soutxtwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(monClick!=null){
                            monClick.click(soutxone.getText().toString());
                }
            }
        });
        soutxone.setOnTextChanged(new CustomStystemView.OntextChanged() {
            @Override
            public void onChanged(String str) {
                if(monClick!=null){
                    monClick.click(str);
                }
            }
        });
        addView(view);
    }



    OnClick monClick;
    public void setOnClickListener(OnClick onClickListener){
        monClick=onClickListener;
    }
    public interface OnClick{
        void click(String str);
    }
}
