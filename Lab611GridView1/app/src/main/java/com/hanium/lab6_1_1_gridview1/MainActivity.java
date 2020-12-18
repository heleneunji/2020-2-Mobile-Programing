package com.hanium.lab6_1_1_gridview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("GridView 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridView gAdapter = new MyGridView(this);
        gv.setAdapter(gAdapter);
    }
}
