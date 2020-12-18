package com.hanium.lab7_1_1_service;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mStart;
    Button mPlay;
    Button mPause;
    Button mStop;

    MusicService mService;

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = ((MusicService.MusicServiceBinder)service).getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mStart = (Button)findViewById(R.id.start);
        Button mPlay = (Button)findViewById(R.id.play);
        Button mPause = (Button)findViewById(R.id.pause);
        Button mStop = (Button)findViewById(R.id.stop);

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent service = new Intent(MainActivity.this, MusicService.class);
                startService(service);
                bindService(service, conn, BIND_AUTO_CREATE);
            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.play();
            }
        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.pause();
            }
        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service = new Intent(MainActivity.this, MusicService.class);
                unbindService(conn);
                stopService(service);
            }
        });

    }
}