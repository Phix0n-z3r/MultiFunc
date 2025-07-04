package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class DiscountActivity extends AppCompatActivity {

    EditText etPrice, etDiscount;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        etPrice = findViewById(R.id.etPrice);
        etDiscount = findViewById(R.id.etDiscount);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            String priceStr = etPrice.getText().toString();
            String discountStr = etDiscount.getText().toString();

            if (priceStr.isEmpty() || discountStr.isEmpty()) {
                Toast.makeText(this, "لطفاً قیمت و درصد تخفیف را وارد کنید", Toast.LENGTH_SHORT).show();
                return;
            }

            float price = Float.parseFloat(priceStr);
            float discount = Float.parseFloat(discountStr);

            if (discount < 0 || discount > 100) {
                Toast.makeText(this, "درصد تخفیف باید بین ۰ تا ۱۰۰ باشد", Toast.LENGTH_SHORT).show();
                return;
            }

            float finalPrice = price - (price * discount / 100);
            tvResult.setText(String.format("قیمت نهایی: %.0f تومان", finalPrice));
        });
    }
}
