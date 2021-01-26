package com.example.timepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    TextView tvTimer1;
    int t1Hour, t1Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        tvTimer1 = findViewById(R.id.tv_timer1);

        tvTimer1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Initialize time picker dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //Initialize hour and minute
                        t1Hour = hourOfDay;
                        t1Minute = minute;
                        //Initialize calendar
                        Calendar calendar = Calendar.getInstance();
                        //Set hour and minute
                        calendar.set(0,0,0, t1Hour, t1Minute);
                        //Set selected time on text view
                        tvTimer1.setText(DateFormat.format("hh:mm aa", calendar));
                    }
                },12,0, false
                );
                //Displayed previous selected time
                timePickerDialog.updateTime(t1Hour, t1Minute);
                //Show dialog
                timePickerDialog.show();
            }
        });


    }
}