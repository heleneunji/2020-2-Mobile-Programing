package com.hanium.lab6_2_2_gallery2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    static ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Gallery 영화 포스터 (Toast 실습)");

        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        ivPoster = (ImageView)findViewById(R.id.ivPoster);

        MyGalleryView galAdapter = new MyGalleryView(this);
        gallery.setAdapter(galAdapter);
    }
}
