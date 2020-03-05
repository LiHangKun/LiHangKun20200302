package com.bawei.lihangkun20200302.activity;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.lihangkun20200302.R;

public class Main2Activity extends AppCompatActivity {

    private Button bt;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt = findViewById(R.id.bt);
        img = findViewById(R.id.img);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator aa = ObjectAnimator.ofFloat(img, "translationY", 0, 500);
                aa.setDuration(5000);
                aa.start();
            }
        });

    }
}
