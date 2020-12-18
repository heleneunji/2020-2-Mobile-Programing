package com.hanium.lab3_4_1_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView objTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTxtView = (TextView)findViewById(R.id.textView1);
        registerForContextMenu(objTxtView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        super.onCreateOptionsMenu(menu);

        MenuItem mnuTextColor = menu.add("Text Color");
        MenuItem mnuTextStyle = menu.add("Text Style");
        MenuItem mnuTextSize = menu.add("Text Size");

        SubMenu etc = menu.addSubMenu("Etc");

        SubMenu mnuMyself = etc.addSubMenu("Myself");
        mnuMyself.setIcon(R.drawable.me1);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
