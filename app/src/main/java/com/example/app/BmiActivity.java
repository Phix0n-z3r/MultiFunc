package com.example.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {

    EditText etWeight, etHeight;
    Button btnCalculate;
    TextView tsbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tsbmi = findViewById(R.id.tsbmi);


        btnCalculate.setOnClickListener(v -> {
            String weightStr = etWeight.getText().toString().trim();
            String heightStr = etHeight.getText().toString().trim();

            if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                try {
                    float weight = Float.parseFloat(weightStr);
                    float height = Float.parseFloat(heightStr) / 100f; // تبدیل سانتی‌متر به متر
                    if (height > 0) {
                        float bmi = weight / (height * height);
                        tsbmi.setText(String.format("BMI شما: %.2f", bmi));
                    } else {
                        tsbmi.setText("قد باید بزرگ‌تر از صفر باشد.");
                    }
                } catch (NumberFormatException e) {
                    tsbmi.setText("عدد معتبر وارد کنید.");
                }
            } else {
                tsbmi.setText("لطفاً وزن و قد را وارد کنید.");
            }
        });
    }
}
