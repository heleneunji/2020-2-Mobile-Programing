package com.hanium.lab3_4_2_submenucolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView objTxtView;

    public static final int ID_GROUP_TEXT_COLOR = 1;
    public static final int ID_GROUP_TEXT_STYLE = 2;
    public static final int ID_GROUP_TEXT_SIZE = 3;
    public static final int ID_GROUP_ME1 = 4;

    public static final int ID_COLOR_RED = 11;
    public static final int ID_COLOR_GREEN = 12;
    public static final int ID_COLOR_BLUE = 13;

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

        //MenuItem mnuTextColor = menu.add("Text Color");
        //MenuItem mnuTextStyle = menu.add("Text Style");
        //MenuItem mnuTextSize = menu.add("Text Size");

        SubMenu mnuTextColor = menu.addSubMenu("Text Color");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_RED, 1, "Red");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_GREEN, 1, "Green");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_BLUE, 1, "Blue");

        SubMenu mnuTextStyle = menu.addSubMenu("Text Style");
        SubMenu mnuTextSize = menu.addSubMenu("Text Size");



        SubMenu etc = menu.addSubMenu("Etc");

        SubMenu mnuMyself = etc.addSubMenu("Myself");
        mnuMyself.setIcon(R.drawable.me1);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case ID_COLOR_RED:
                objTxtView.setTextColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTxtView.setTextColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTxtView.setTextColor(Color.BLUE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
