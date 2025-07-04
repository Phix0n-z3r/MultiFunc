package com.example.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvStatus, tvRegister;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvStatus = findViewById(R.id.tvStatus);
        tvRegister = findViewById(R.id.tvRegister);

        prefs = getSharedPreferences("userPrefs", MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {
            String user = etUsername.getText().toString();
            String pass = etPassword.getText().toString();

            String savedUser = prefs.getString("username", "");
            String savedPass = prefs.getString("password", "");

            if(user.isEmpty() || pass.isEmpty()) {
                tvStatus.setText("لطفاً نام کاربری و رمز را وارد کنید.");
                return;
            }

            if (user.equals(savedUser) && pass.equals(savedPass)) {
                tvStatus.setText("ورود موفق!");
                Intent intent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("your host url here توجه توجه"));
                startActivity(intent);
            } else {
                tvStatus.setText("نام کاربری یا رمز عبور اشتباه است.");
            }
        });

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
