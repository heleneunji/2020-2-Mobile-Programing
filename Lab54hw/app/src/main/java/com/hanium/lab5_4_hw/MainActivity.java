package com.hanium.lab5_4_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_moon = (ImageView)findViewById(R.id.moon);
        Animation anim_moon = AnimationUtils.loadAnimation(this, R.anim.moon);
        iv_moon.startAnimation(anim_moon);

        ImageView iv_bird = (ImageView)findViewById(R.id.bird);
        Animation anim_bird = AnimationUtils.loadAnimation(this, R.anim.bird);

        AnimationDrawable animation_drawable = new AnimationDrawable();
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.sun);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.moon);
        animation_drawable.addFrame(frame1, 200);
        animation_drawable.addFrame(frame2, 200);
        iv_bird.setBackgroundDrawable(animation_drawable);
        animation_drawable.start();
    }
}
