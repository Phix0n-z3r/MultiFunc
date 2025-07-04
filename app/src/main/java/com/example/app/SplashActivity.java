package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ایجاد یک تاخیر 2 ثانیه‌ای برای نمایش لوگو
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // پس از 2 ثانیه به MainActivity میرویم
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // به این معناست که SplashActivity را از stack حذف می‌کنیم
            }
        }, 2000); // 2000 میلی‌ثانیه = 2 ثانیه
    }
}
