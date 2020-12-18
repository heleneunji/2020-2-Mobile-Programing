package com.hanium.final1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

public class PastJavaClass2020Activity extends AppCompatActivity {
    static ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastjavaclass);

        setTitle("2020년 객체지향프로그래밍 강의 계획서");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        ivPoster = (ImageView)findViewById(R.id.ivPoster);

        PastJavaGalleryView2020 galAdapter = new PastJavaGalleryView2020(this);
        gallery.setAdapter(galAdapter);
    }
}
