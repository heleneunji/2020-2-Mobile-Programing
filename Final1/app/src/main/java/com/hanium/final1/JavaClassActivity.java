package com.hanium.final1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

//import com.google.android.material.tabs.TabLayout;

public class JavaClassActivity extends TabActivity {
    TabHost myTabHost = null;
    TabHost.TabSpec spec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaclass);

        myTabHost = getTabHost();

        spec = myTabHost.newTabSpec("Tab1").setIndicator("과목 해석").setContent(R.id.textView1);
        myTabHost.addTab(spec);

        spec = myTabHost.newTabSpec("Tab2").setIndicator("선행 과목").setContent(R.id.textView2);
        myTabHost.addTab(spec);

        spec = myTabHost.newTabSpec("Tab3").setIndicator("지난 3년 정보").setContent(R.id.listview1);
        myTabHost.addTab(spec);

        ListView list = (ListView)findViewById(R.id.listview1);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent(getApplicationContext(), PastJavaClass2020Activity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(), PastJavaClass2019Activity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getApplicationContext(), PastJavaClass2018Activity.class);
                        startActivity(intent3);
                        break;
                }
            }
        });

        myTabHost.setCurrentTab(0);
    }
}
