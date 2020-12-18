package com.hanium.lab3_5_2_callingevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText objET = (EditText)findViewById(R.id.editText1);
        final Button btnCall = (Button)findViewById(R.id.button1);
        final Button btnStop = (Button)findViewById(R.id.button2);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //objET.setText("통화중... ");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //objET.setText("통화가 종료되었습니다.");
            }
        });
    }
}
