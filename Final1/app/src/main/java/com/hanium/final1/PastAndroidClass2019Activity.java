package com.hanium.final1;

import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PastAndroidClass2019Activity  extends AppCompatActivity {
    static ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastandroidclass);

        setTitle("2019년 모바일 프로그래밍 강의 계획서");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        ivPoster = (ImageView)findViewById(R.id.ivPoster);

        PastAndroidGalleryView2019 galAdapter = new PastAndroidGalleryView2019(this);
        gallery.setAdapter(galAdapter);
    }
}
