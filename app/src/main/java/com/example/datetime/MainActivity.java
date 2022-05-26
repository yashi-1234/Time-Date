package com.example.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button dateButton, timeButton;
    TextView dateTextview,timeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateButton = findViewById(R.id.dateButton);
        timeButton = findViewById(R.id.timeButton);
        dateTextview = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }

        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handletimeButton();
            }
        });

    }
    private void handletimeButton(){
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String timeString = "Hour: " + hour + " " + "Minute: "+ minute;
                timeTextView.setText(timeString);
                Calendar calendar1 =Calendar.getInstance();
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);

                CharSequence charSequence = DateFormat.format("hh:mm a", calendar1);
                timeTextView.setText(charSequence);
            }
        }, HOUR, MINUTE, is24HourFormat);
        timePickerDialog.show();
        }
    private void handleDateButton(){
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                String dateString= year + "/" + month + "/" + date;
                dateTextview.setText(dateString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);

                CharSequence dateCharSequence = DateFormat.format("EEEE, dd MMM yyyy", calendar1);
                dateTextview.setText(dateCharSequence);


            }
        },YEAR, MONTH, DATE);

        datePickerDialog.show();
    }

}