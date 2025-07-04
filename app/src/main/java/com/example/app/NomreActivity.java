package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class NomreActivity extends AppCompatActivity {

    EditText etScore;
    Button btnCheck;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomre); // ← اینجا فایل XML جدید

        etScore = findViewById(R.id.etScore);
        btnCheck = findViewById(R.id.btnCheck);
        tvResult = findViewById(R.id.tvResult);

        btnCheck.setOnClickListener(v -> {
            String scoreStr = etScore.getText().toString().trim();

            if (!scoreStr.isEmpty()) {
                float score = Float.parseFloat(scoreStr);
                String rank;

                if (score >= 18 && score <= 20) {
                    rank = "عالی";
                } else if (score >= 16) {
                    rank = "خیلی خوب";
                } else if (score >= 14) {
                    rank = "خوب";
                } else if (score >= 10) {
                    rank = "مشروط";
                } else if (score >= 0) {
                    rank = "مردود";
                } else {
                    rank = "نمره نامعتبر است!";
                }

                tvResult.setText(String.format("نمره: %.1f\nرتبه: %s", score, rank));
            } else {
                Toast.makeText(this, "لطفاً نمره را وارد کنید", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
