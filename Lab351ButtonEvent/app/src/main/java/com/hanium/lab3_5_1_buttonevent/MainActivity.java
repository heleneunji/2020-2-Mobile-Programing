package com.hanium.lab3_5_1_buttonevent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView objTv;
    private LinearLayout objLayout;
    private LinearLayout objSubLayout;
    private Button objBnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objLayout = (LinearLayout)findViewById(R.id.LinearLayout1);
        objSubLayout = (LinearLayout)findViewById(R.id.LinearLayout2);
        objTv = (TextView)findViewById(R.id.textView1);
        objBnt = (Button)findViewById(R.id.button1);

        objBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random1 = new Random().nextInt(256);
                int random2 = new Random().nextInt(256);
                int random3 = new Random().nextInt(256);

                int color = Color.rgb(random1, random2, random3);
                objSubLayout.setBackgroundColor(color);
                objTv.setText("RGB("+random1+", "+random2+", "+random3+")");

            }
        });
    }
}
