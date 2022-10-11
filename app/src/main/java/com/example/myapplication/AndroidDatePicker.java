package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class AndroidDatePicker extends AppCompatActivity {

    private Button pickDateBtn;
    private TextView selectedDateTV;
    private Button openNextScrenn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);
        openNextScrenn = findViewById(R.id.nextScreenBtn);

        pickDateBtn.setOnClickListener((View.OnClickListener) v -> {
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    AndroidDatePicker.this,
                    (view, year1, monthOfYear, dayOfMonth) ->
                            selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1),
                    year, month, day);
            datePickerDialog.show();
        });

        openNextScrenn.setOnClickListener(v -> {
            openNextScreen();
        });
    }

    public void openNextScreen() {
        Intent intent = new Intent(this, AndroidSpinner.class);
        startActivity(intent);
    }
}