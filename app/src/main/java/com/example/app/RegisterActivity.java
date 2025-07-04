package com.example.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etNewUsername, etNewPassword;
    Button btnRegister;
    TextView tvResult;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvResult = findViewById(R.id.tvResult);

        prefs = getSharedPreferences("userPrefs", MODE_PRIVATE);

        btnRegister.setOnClickListener(v -> {
            String user = etNewUsername.getText().toString();
            String pass = etNewPassword.getText().toString();

            if (user.isEmpty() || pass.isEmpty()) {
                tvResult.setText("لطفاً تمام فیلدها را پر کنید.");
                return;
            }

            prefs.edit()
                    .putString("username", user)
                    .putString("password", pass)
                    .apply();

            tvResult.setText("ثبت‌نام با موفقیت انجام شد!");
        });
    }
}
