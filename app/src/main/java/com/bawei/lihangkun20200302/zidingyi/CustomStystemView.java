package com.bawei.lihangkun20200302.zidingyi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class CustomStystemView extends EditText {
    String a;
    Handler handler=new Handler();
    public CustomStystemView(Context context) {
        super(context);
        init();

    }

    public CustomStystemView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 a = s.toString();
                 handler.removeCallbacks(runnable);
                 handler.postDelayed(runnable,1000);
            }
        });
    }
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if(montextChanged!=null){
                    montextChanged.onChanged(a);
                }
            }
        };
    OntextChanged montextChanged;
    public void setOnTextChanged(OntextChanged onTextChanged){
        montextChanged=onTextChanged;
    }
    public interface OntextChanged{
        void onChanged(String str);
    }
}
