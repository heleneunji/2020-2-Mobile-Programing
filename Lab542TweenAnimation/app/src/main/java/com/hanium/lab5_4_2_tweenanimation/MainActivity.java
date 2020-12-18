package com.hanium.lab5_4_2_tweenanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button fadeButton = (Button) findViewById(R.id.buttonAlpha);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.transparency);
            }
        });

        final Button growButton = (Button) findViewById(R.id.buttonScale);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.grow);
            }
        });

        final Button moveButton = (Button) findViewById(R.id.buttonTranslate);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.translate);
            }
        });

        final Button spinButton = (Button) findViewById(R.id.buttonRotate);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.spin);
            }
        });

        final Button allButton = (Button) findViewById(R.id.buttonAll);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimation(R.anim.shakennotstirred);
            }
        });
    }

    private void performAnimation(int animationResourceID)
    {
        ImageView reusableImageView = (ImageView)findViewById(R.id.imageViewForTweening);
        reusableImageView.setImageResource(R.drawable.pic4);
        reusableImageView.setVisibility(View.VISIBLE);

        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);

        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ImageView reusableImageView = (ImageView)findViewById(R.id.imageViewForTweening);
                reusableImageView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        reusableImageView.startAnimation(an);
    }
}
