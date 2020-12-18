package com.hanium.lab3_5_3_checkradioevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView objTV;
    private LinearLayout objLayout;
    private RadioButton rdoScreenSet;
    private RadioButton rdoScreenReset;
    private CheckBox chkColor_R;
    private CheckBox chkColor_G;
    private CheckBox chkColor_B;
    private int bkColor = 0xFF000000;
    private String strData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTV = (TextView)findViewById(R.id.textView3);
        objLayout = (LinearLayout)findViewById(R.id.LinearLayout);

        rdoScreenSet = (RadioButton)findViewById(R.id.radioButton1);
        rdoScreenReset = (RadioButton)findViewById(R.id.radioButton2);
        rdoScreenSet.setOnClickListener(rdoScreen_listener);
        rdoScreenReset.setOnClickListener(rdoScreen_listener);

        chkColor_R = (CheckBox)findViewById(R.id.checkBox1);
        chkColor_G = (CheckBox)findViewById(R.id.checkBox2);
        chkColor_B = (CheckBox)findViewById(R.id.checkBox3);
        chkColor_R.setOnClickListener(setColor_listener);
        chkColor_G.setOnClickListener(setColor_listener);
        chkColor_B.setOnClickListener(setColor_listener);
    }

    View.OnClickListener rdoScreen_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (rdoScreenSet.isChecked()) {
                strData = "Color Setting Mode : " + rdoScreenSet.getText().toString();
            } else{
                strData = "Color Setting Mode : " + rdoScreenSet.getText().toString();
                chkColor_R.setChecked(false);
                chkColor_G.setChecked(false);
                chkColor_B.setChecked(false);
                objTV.setBackgroundColor(0xFFFFFFFF);
                objTV.setTextColor(0XFF000000);
            }
            objTV.setText(strData);
        }
    };

    View.OnClickListener setColor_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckBox chkColor = (CheckBox)v;
            if (rdoScreenSet.isChecked()) {
                strData = "Color Setting Mode : " + rdoScreenSet.getText().toString();
                if (chkColor_R.isChecked()) bkColor = 0xFFFF0000;
                if (chkColor_G.isChecked()) bkColor = 0xFF00FF00;
                if (chkColor_B.isChecked()) bkColor = 0xFF0000FF;
                objTV.setBackgroundColor(bkColor);
                objTV.setTextColor(0xFF000000);
                objLayout.setBackgroundColor(bkColor);
                objTV.setBackgroundColor(bkColor);
                bkColor = 0xFF000000;
            } else {
                objTV.setTextColor(0xFF000000);
                objTV.setText("Color Setting Mode를 Set으로 지정하세요.");
                chkColor.setChecked(false);
            }
        }
    };
}
