package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    EditText etNumber1, etNumber2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        tvResult = findViewById(R.id.tvResult);

        View.OnClickListener listener = v -> {
            String num1Str = etNumber1.getText().toString();
            String num2Str = etNumber2.getText().toString();

            if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result;

                if (v.getId() == R.id.btnAdd) {
                    result = num1 + num2;
                } else if (v.getId() == R.id.btnSubtract) {
                    result = num1 - num2;
                } else if (v.getId() == R.id.btnMultiply) {
                    result = num1 * num2;
                } else {
                    if (num2 == 0) {
                        Toast.makeText(this, "تقسیم بر صفر ممکن نیست", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1 / num2;
                }

                tvResult.setText(String.format("نتیجه: %.2f", result));
            } else {
                Toast.makeText(this, "لطفاً هر دو عدد را وارد کنید", Toast.LENGTH_SHORT).show();
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSubtract.setOnClickListener(listener);
        btnMultiply.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
    }
}
