package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSms, btnBmi, btnAge, btnLogin, btnChart, btnSecurePassword, btnFactorial;
    Button btnTutorial, btnCalculate, btnAgeGroup, btnNomre, btnDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSms = findViewById(R.id.btnSms);
        btnBmi = findViewById(R.id.btnBmi);
        btnAge = findViewById(R.id.btnAge);
        btnLogin = findViewById(R.id.btnLogin);
        btnTutorial = findViewById(R.id.btnTutorial);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnAgeGroup = findViewById(R.id.btnAgeGroup);
        btnNomre = findViewById(R.id.btnNomre);
        btnDiscount = findViewById(R.id.btnDiscount); 
        btnSecurePassword= findViewById(R.id.btnSecurePassword);

        btnSms.setOnClickListener(v -> startActivity(new Intent(this, SmsActivity.class)));
        btnBmi.setOnClickListener(v -> startActivity(new Intent(this, BmiActivity.class)));
        btnAge.setOnClickListener(v -> startActivity(new Intent(this, AgeActivity.class)));
        btnLogin.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
        btnTutorial.setOnClickListener(v -> startActivity(new Intent(this, TutorialActivity.class)));
        btnCalculate.setOnClickListener(v -> startActivity(new Intent(this, CalculatorActivity.class)));
        btnAgeGroup.setOnClickListener(v -> startActivity(new Intent(this, AgeGroupActivity.class)));
        btnNomre.setOnClickListener(v -> startActivity(new Intent(this, NomreActivity.class)));
        btnDiscount.setOnClickListener(v -> startActivity(new Intent(this, DiscountActivity.class)));
        btnSecurePassword.setOnClickListener(v -> startActivity(new Intent(this, SecurePasswordActivity.class)));
    }
}
