package com.hanium.lab4_2_intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {
    TextView result;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        result = (TextView)findViewById(R.id.result);
        btn=(Button)findViewById(R.id.button2);

        Bundle extras = getIntent().getExtras();
        result.setText("ID = "+extras.getString("id") + "\nPassword = "+extras.getString("pw") + "\n");

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
