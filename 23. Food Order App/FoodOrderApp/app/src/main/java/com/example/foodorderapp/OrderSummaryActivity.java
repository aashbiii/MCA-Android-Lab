package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OrderSummaryActivity extends AppCompatActivity {

    private TextView tvName, tvMobile, tvMealType, tvItems, tvTotalBill;
    private Button btnGenerateInvoice;

    private String name, mobile, mealType;
    private ArrayList<String> items;
    private double totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        tvName = findViewById(R.id.tvSummaryName);
        tvMobile = findViewById(R.id.tvSummaryMobile);
        tvMealType = findViewById(R.id.tvSummaryMealType);
        tvItems = findViewById(R.id.tvSummaryItems);
        tvTotalBill = findViewById(R.id.tvTotalBill);
        btnGenerateInvoice = findViewById(R.id.btnGenerateInvoice);

        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra("CUSTOMER_NAME");
            mobile = intent.getStringExtra("MOBILE_NUMBER");
            mealType = intent.getStringExtra("MEAL_TYPE");
            items = intent.getStringArrayListExtra("SELECTED_ITEMS");
            totalBill = intent.getDoubleExtra("TOTAL_BILL", 0.0);

            tvName.setText("Name: " + name);
            tvMobile.setText("Mobile: " + mobile);
            tvMealType.setText("Meal Type: " + mealType);

            StringBuilder itemsFormatted = new StringBuilder("Selected Items:\n");
            if (items != null) {
                for (String item : items) {
                    itemsFormatted.append(" • ").append(item).append("\n");
                }
            }
            tvItems.setText(itemsFormatted.toString().trim());
            tvTotalBill.setText(String.format("Total Bill Amount: ₹%.2f", totalBill));
        }

        btnGenerateInvoice.setOnClickListener(v -> {
            Intent invoiceIntent = new Intent(OrderSummaryActivity.this, FinalInvoiceActivity.class);
            invoiceIntent.putExtra("CUSTOMER_NAME", name);
            invoiceIntent.putExtra("MOBILE_NUMBER", mobile);
            invoiceIntent.putExtra("MEAL_TYPE", mealType);
            invoiceIntent.putStringArrayListExtra("SELECTED_ITEMS", items);
            invoiceIntent.putExtra("TOTAL_BILL", totalBill);
            startActivity(invoiceIntent);
        });
    }
}

