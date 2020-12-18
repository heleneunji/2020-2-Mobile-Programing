package com.hanium.lab3_5_4_toggleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton objTButton = (ToggleButton)findViewById(R.id.toggleButton1);
        objTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (objTButton.isChecked()) {
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
