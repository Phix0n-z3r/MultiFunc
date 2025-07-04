package com.example.app;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AgeActivity extends AppCompatActivity {

    Button btnSelectDate, btnCalculate;
    TextView tvResult;
    int birthYear = 0, birthMonth = 0, birthDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnSelectDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                birthYear = year1;
                birthMonth = month1;
                birthDay = dayOfMonth;
                btnSelectDate.setText(String.format("%d/%02d/%02d", birthYear, birthMonth + 1, birthDay));
            }, year, month, day);
            dpd.show();
        });

        btnCalculate.setOnClickListener(v -> {
            if (birthYear == 0) {
                Toast.makeText(this, "لطفاً تاریخ تولد را انتخاب کنید", Toast.LENGTH_SHORT).show();
                return;
            }

            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - birthYear;

            // بررسی اینکه تولد امسال گذشته یا نه
            Calendar birthdayThisYear = Calendar.getInstance();
            birthdayThisYear.set(Calendar.YEAR, today.get(Calendar.YEAR));
            birthdayThisYear.set(Calendar.MONTH, birthMonth);
            birthdayThisYear.set(Calendar.DAY_OF_MONTH, birthDay);

            if (today.before(birthdayThisYear)) {
                age--;
            }

            tvResult.setText("سن شما: " + age + " سال");
        });
    }
}
