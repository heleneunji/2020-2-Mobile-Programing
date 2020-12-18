package com.hanium.lab4_2_intents;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IntentTestActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);

        setContentView(R.layout.activity_intent_test);
        ListView list = (ListView) findViewById(R.id.intentlist);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01099065080"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0109965080"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_SEARCH);
                        intent.putExtra(SearchManager.QUERY, "abc");
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:01099065080"));
                        intent.putExtra("sms_body", "안녕하세요");
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY,"android");
                        break;
                    case 5:
                        intent = new Intent(Intent.ACTION_PICK,Uri.parse("content://contacts/people"));
                        break;
                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://daum.net"));
                        break;
                    case 7:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:01099065080"));
                        break;
                    case 8:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.501079, 127.061194"));
                        break;

                }
                try{
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    Toast.makeText(IntentTestActivity.this, "지정한 동작을 실행할 App이 설치되어 있지 않습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
