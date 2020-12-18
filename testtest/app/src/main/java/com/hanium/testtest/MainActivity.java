package com.hanium.testtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button javaclassbtn = (Button)findViewById(R.id.button);
        javaclassbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "예약이 완료되었습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),test.class);
                startActivity(intent);
            }
        });
    }
}