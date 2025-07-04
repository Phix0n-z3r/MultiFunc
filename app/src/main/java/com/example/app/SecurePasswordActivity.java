package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SecurePasswordActivity extends AppCompatActivity {

    EditText etPassword;
    TextView tvStrength;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_password);

        etPassword = findViewById(R.id.etPassword);
        tvStrength = findViewById(R.id.tvStrength);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(v -> {
            String password = etPassword.getText().toString();
            if (password.isEmpty()) {
                Toast.makeText(this, "رمز را وارد کنید", Toast.LENGTH_SHORT).show();
                return;
            }

            int score = calculateStrength(password);
            String strengthText;

            if (score < 3) {
                strengthText = "ضعیف";
                tvStrength.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            } else if (score < 5) {
                strengthText = "متوسط";
                tvStrength.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));
            } else {
                strengthText = "قوی";
                tvStrength.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            }

            tvStrength.setText("قدرت رمز: " + strengthText);
        });
    }

    private int calculateStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches("(?=.*[a-z]).*")) score++;
        if (password.matches("(?=.*[A-Z]).*")) score++;
        if (password.matches("(?=.*[0-9]).*")) score++;
        if (password.matches("(?=.*[@#$%^&+=!]).*")) score++;

        return score;
    }
}
