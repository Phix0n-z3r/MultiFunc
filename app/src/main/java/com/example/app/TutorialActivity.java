package com.example.app;

import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity extends AppCompatActivity {

    Button btnToast, btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        btnToast = findViewById(R.id.btnToast);
        btnLog = findViewById(R.id.btnLog);

        btnToast.setOnClickListener(v -> {
            Toast.makeText(this, "این یک Toast است", Toast.LENGTH_SHORT).show();
        });

        btnLog.setOnClickListener(v -> {
            Log.d("Tutorial", "این پیام در Logcat نمایش داده می‌شود");
        });
    }
}
