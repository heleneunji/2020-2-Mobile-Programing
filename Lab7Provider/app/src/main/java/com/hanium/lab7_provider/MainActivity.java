package com.hanium.lab7_provider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button callRecord;
    EditText edtRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callRecord = (Button)findViewById(R.id.btnCallHistory);
        edtRecord = (EditText)findViewById(R.id.edtCallRecord);
        callRecord.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                edtRecord.setText(getCallHistoty());
            }
        });
        checkDangerousPermissions();
    }

    public String getCallHistoty() {
        String[] callSet = new String[]{CallLog.Calls.DATE, CallLog.Calls.TYPE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI, callSet, null, null, null);
        if (c == null) return "통화기록 없음";

        StringBuffer callBuff = new StringBuffer();
        callBuff.append("\n날짜 : 구분 : 전화번호 : 통화시간\n\n");
        c.moveToFirst();
        do {
            long callDate = c.getLong(0);
            SimpleDateFormat datePattern = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = datePattern.format(new Date(callDate));
            callBuff.append(date_str + ":");
            if (c.getInt(1) == CallLog.Calls.INCOMING_TYPE) callBuff.append("착신 : ");
            else callBuff.append("발신 : ");
            callBuff.append(c.getString(2) + ":");
            callBuff.append(c.getString(3) + "초\n");
        } while(c.moveToNext());

        c.close();
        return callBuff.toString();
    }

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.READ_CALL_LOG
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "권한이 승인됨", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "권한이 승인되지 않음", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
