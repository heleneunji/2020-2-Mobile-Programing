package com.hanium.lab8_1_1broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class SmsDisplayActivity extends Activity {
    Button titleButton;
    Button closeButton;
    TextView messageTextView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sms_display);

        titleButton = (Button) findViewById(R.id.titleButton);
        closeButton = (Button) findViewById(R.id.closeButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent passedIntent = getIntent();
        if(passedIntent != null){
            processIntent(passedIntent);
        }
    }

    protected void onNewIntent(Intent intent){
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){
        String number = intent.getStringExtra("number");
        String message = intent.getStringExtra("message");
        String timestamp = intent.getStringExtra("timestamp");

        if(number != null){
            titleButton.setText(number + "번호");
            messageTextView.setText("["+timestamp+"]"+message);
            messageTextView.invalidate();
        }
    }
}