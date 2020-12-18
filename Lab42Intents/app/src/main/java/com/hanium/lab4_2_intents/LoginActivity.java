package com.hanium.lab4_2_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText edit_id;
    private EditText edit_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_id=(EditText)findViewById(R.id.editText1);
        edit_pw=(EditText)findViewById(R.id.editText2);

        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String idtext;
                String pwtext;

                idtext = edit_id.getText().toString();
                pwtext = edit_pw.getText().toString();

                Intent intent = new Intent(LoginActivity.this, NextActivity.class);

                Bundle extras = new Bundle();
                extras.putString("id", idtext);
                extras.putString("pw", pwtext);

                //Intent.putExtras(extras);

                startActivity(intent);
            }
        });
    }
}
