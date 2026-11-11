package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class FinalInvoiceActivity extends AppCompatActivity {

    private TextView tvName, tvMobile, tvMealType, tvItems;
    private TextView tvSubtotal, tvDiscount, tvFinalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_invoice);

        tvName = findViewById(R.id.tvInvoiceName);
        tvMobile = findViewById(R.id.tvInvoiceMobile);
        tvMealType = findViewById(R.id.tvInvoiceMealType);
        tvItems = findViewById(R.id.tvInvoiceItems);
        tvSubtotal = findViewById(R.id.tvInvoiceSubtotal);
        tvDiscount = findViewById(R.id.tvInvoiceDiscount);
        tvFinalAmount = findViewById(R.id.tvInvoiceFinalAmount);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("CUSTOMER_NAME");
            String mobile = intent.getStringExtra("MOBILE_NUMBER");
            String mealType = intent.getStringExtra("MEAL_TYPE");
            ArrayList<String> items = intent.getStringArrayListExtra("SELECTED_ITEMS");
            double totalBill = intent.getDoubleExtra("TOTAL_BILL", 0.0);

            tvName.setText("Customer Name: " + name);
            tvMobile.setText("Mobile: " + mobile);
            tvMealType.setText("Meal Type: " + mealType);

            StringBuilder itemsFormatted = new StringBuilder("Ordered Items:\n");
            if (items != null) {
                for (String item : items) {
                    itemsFormatted.append(" • ").append(item).append("\n");
                }
            }
            tvItems.setText(itemsFormatted.toString().trim());

            double discountRate = 0.0;
            if (totalBill > 800) {
                discountRate = 0.15;
            } else if (totalBill >= 500) {
                discountRate = 0.10;
            } else {
                discountRate = 0.00;
            }

            double discountAmount = totalBill * discountRate;
            double finalAmount = totalBill - discountAmount;

            tvSubtotal.setText(String.format("Subtotal: ₹%.2f", totalBill));
            tvDiscount.setText(String.format("Discount (%.0f%%): -₹%.2f", discountRate * 100, discountAmount));
            tvFinalAmount.setText(String.format("Final Amount Payable: ₹%.2f", finalAmount));
        }
    }
}

