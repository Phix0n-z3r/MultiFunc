package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class AgeGroupActivity extends AppCompatActivity {

    EditText etAge;
    Button btnCheckGroup;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_group);

        etAge = findViewById(R.id.etAge);
        btnCheckGroup = findViewById(R.id.btnCheckGroup);
        tvResult = findViewById(R.id.tvResult);

        btnCheckGroup.setOnClickListener(v -> {
            String ageStr = etAge.getText().toString();

            if (!ageStr.isEmpty()) {
                int age = Integer.parseInt(ageStr);
                String group;

                if (age < 0) {
                    group = "سن نامعتبر است.";
                } else if (age <= 12) {
                    group = "کودک";
                } else if (age <= 18) {
                    group = "نوجوان";
                } else if (age <= 35) {
                    group = "جوان";
                } else if (age <= 60) {
                    group = "بزرگسال";
                } else {
                    group = "سالمند";
                }

                tvResult.setText("گروه سنی شما: " + group);
            } else {
                Toast.makeText(this, "لطفاً سن را وارد کنید", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
