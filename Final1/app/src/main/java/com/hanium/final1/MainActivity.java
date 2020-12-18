package com.hanium.final1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("숙명ITs'");

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IntroduceProfessor.class);
                startActivity(intent);
            }
        });

        ListView list1 = (ListView)findViewById(R.id.sopho_1);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent1 = new Intent(getApplicationContext(), JavaClassActivity.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });

        ListView list2 = (ListView)findViewById(R.id.junior_2);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent intent3 = new Intent(getApplicationContext(), NetworkClassActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        break;
                }
            }
        });

        ListView list3 = (ListView)findViewById(R.id.sopho_2);
        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Intent intent2 = new Intent(getApplicationContext(), AndroidClassActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
    }
}
