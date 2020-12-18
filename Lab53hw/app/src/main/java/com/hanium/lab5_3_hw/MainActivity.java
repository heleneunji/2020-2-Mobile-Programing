package com.hanium.lab5_3_hw;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<WritingVO> writing = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        writing = new ArrayList<WritingVO>();
        Canvas canvas = new Canvas();
        WritingVO wVO1 = new WritingVO((float) 100, (float)100);
        WritingVO wVO2 = new WritingVO((float) 1, (float)10);

        writing.add(wVO1);
        writing.add(wVO2);

        CircleChart cc = new CircleChart(this, writing, 100, 500);
        setContentView(cc);
    }
}