package com.hanium.lab5_2_2_photobook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("My Photo 목록");
    }

    public void displayPicture(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout)v.findViewById(id);
        String tag = (String)layout.getTag();

        Intent it = new Intent(this, PhotoActivity.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }

    public void closePicture(View v) {
        finish();
    }
}
