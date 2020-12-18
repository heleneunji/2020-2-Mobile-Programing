package com.hanium.lab6_1_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {

    private Button buttonReservationStart;
    private Button buttonReservationComplete;
    private RadioGroup radioGroup;

    private DatePicker datePicker;
    private TimePicker timePicker;

    private Chronometer chronometerReservationTime;

    private TextView reservationDateTimeText;

    private TextView textReservationStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonReservationStart = (Button)findViewById(R.id.buttonReservationStart);
        buttonReservationStart.setOnClickListener(this);

        buttonReservationComplete = (Button)findViewById(R.id.buttonReservationCompleted);
        buttonReservationComplete.setOnClickListener(this);

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        timePicker = (TimePicker)findViewById(R.id.timePicker);

        chronometerReservationTime = (Chronometer)findViewById(R.id.chronometerReservationTime);

        reservationDateTimeText = (TextView) findViewById(R.id.textReservatedDateTime);
        textReservationStatus = (TextView) findViewById(R.id.textReservationStatus);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        initViewObjects(false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void onClick(View v) {
        if(v instanceof Button) { // 클릭한 주체가 버튼이라면
            Button clickButtonObj = (Button) v;

            //현재 어떤 버튼이 클릭되었는지 확인
            if(R.id.buttonReservationStart == clickButtonObj.getId()) { //[1] 예약 시작 버튼일 경우
                textReservationStatus.setText(getResources().getString(R.string.reservationStatusReservating));

                initViewObjects(true);

                Toast.makeText(MainActivity.this, "Start reservation from now!!", Toast.LENGTH_SHORT).show();
                chronometerReservationTime.setBase(SystemClock.elapsedRealtime());
                chronometerReservationTime.start();

                reservationDateTimeText.setVisibility(View.INVISIBLE);
                reservationDateTimeText.setText(getResources().getString(R.string.none));

                if(radioGroup.getCheckedRadioButtonId() == R.id.radioChooseCalendar) {
                    datePicker.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                } else if(radioGroup.getCheckedRadioButtonId() == R.id.radioChooseTime){
                    datePicker.setVisibility(View.INVISIBLE);
                    timePicker.setVisibility(View.VISIBLE);
                }

            } else if(R.id.buttonReservationCompleted == clickButtonObj.getId()) { //[2] 예약 완료 버튼일 경우
                textReservationStatus.setText(R.string.setReservationCompleted);

                String reservationCompleted = String.format(getResources().getString(R.string.reservationCompleted));

                initViewObjects(false);

                Toast.makeText(MainActivity.this, "Reservation completed!!", Toast.LENGTH_SHORT).show();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();
                reservationDateTimeText.setVisibility(View.VISIBLE);
                reservationDateTimeText.setText("예약날짜: "+year+"년 "+month+"월 "+day+"일("+hour+":"+minute+")"+reservationCompleted);

                chronometerReservationTime.stop();
            }
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup rg, int arg1) {
        RadioButton radButton = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

        if(radButton.getId() == R.id.radioChooseCalendar) {
            datePicker.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
        } else if(radButton.getId() == R.id.radioChooseTime){
            datePicker.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.VISIBLE);
        }
    }

    private void initViewObjects(boolean makeDisable) {
        ViewGroup itemGroup = (ViewGroup)findViewById(R.id.itemGroup);

        for(int i=0; i < itemGroup.getChildCount(); i++) {
            View v = (View)itemGroup.getChildAt(i);

            v.setEnabled(makeDisable);
        }
    }
}