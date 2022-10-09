package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class AndroidTimePicker extends AppCompatActivity {

    private Button pickTimeBtn;
    private TextView selectedTimeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickTimeBtn = findViewById(R.id.idBtnPickTime);
        selectedTimeTV = findViewById(R.id.idTVSelectedTime);

        pickTimeBtn.setOnClickListener(v -> {

            final Calendar c = Calendar.getInstance();

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(AndroidTimePicker.this,
                    (view, hourOfDay, minute1) -> {
                        selectedTimeTV.setText(hourOfDay + ":" + minute1);
                    }, hour, minute, false);
            timePickerDialog.show();
        });
    }
}