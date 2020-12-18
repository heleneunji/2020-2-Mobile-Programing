package com.hanium.lab5_4_1_frameanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable mframeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button onButton = (Button) findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        final Button offButton = (Button) findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

        private void startAnimation()
        {
            ImageView img = (ImageView)findViewById(R.id.imageView_Juggle);

            BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic1);
            BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic2);
            BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic3);
            BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.pic4);

            int reasonableDuration = 1000;
            mframeAnimation = new AnimationDrawable();

            mframeAnimation.setOneShot(false);
            mframeAnimation.addFrame(frame1, reasonableDuration);
            mframeAnimation.addFrame(frame2, reasonableDuration);
            mframeAnimation.addFrame(frame3, reasonableDuration);
            mframeAnimation.addFrame(frame4, reasonableDuration);

            img.setBackgroundDrawable(mframeAnimation);

            mframeAnimation.setVisible(true, true);
            mframeAnimation.start();
        }

        private void stopAnimation()
        {
            mframeAnimation.stop();
            mframeAnimation.setVisible(false,false);
        }
    }
