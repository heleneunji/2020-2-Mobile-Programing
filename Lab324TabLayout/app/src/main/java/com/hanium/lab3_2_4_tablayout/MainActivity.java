package com.hanium.lab3_2_4_tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends TabActivity {
    TabHost myTabHost = null;
    TabHost.TabSpec spec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTabHost = getTabHost();

        spec = myTabHost.newTabSpec("Tab1").setIndicator("Tab1").setContent(R.id.textView1);
        myTabHost.addTab(spec);

        spec = myTabHost.newTabSpec("Tab2").setIndicator("Tab2").setContent(R.id.textView2);
        myTabHost.addTab(spec);

        spec = myTabHost.newTabSpec("Tab3").setIndicator("Tab3").setContent(R.id.textView3);
        myTabHost.addTab(spec);

        myTabHost.setCurrentTab(0);
    }
}
