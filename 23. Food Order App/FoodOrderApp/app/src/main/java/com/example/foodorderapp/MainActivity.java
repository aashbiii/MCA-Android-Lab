package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etCustomerName, etMobileNumber;
    private RadioGroup rgMealType;
    private CheckBox cbPizza, cbBurger, cbSandwich, cbSoftDrink;
    private Button btnPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCustomerName = findViewById(R.id.etCustomerName);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        rgMealType = findViewById(R.id.rgMealType);
        cbPizza = findViewById(R.id.cbPizza);
        cbBurger = findViewById(R.id.cbBurger);
        cbSandwich = findViewById(R.id.cbSandwich);
        cbSoftDrink = findViewById(R.id.cbSoftDrink);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        btnPlaceOrder.setOnClickListener(v -> validateAndSubmitOrder());
    }

    private void validateAndSubmitOrder() {
        String name = etCustomerName.getText().toString().trim();
        String mobile = etMobileNumber.getText().toString().trim();

        if (name.isEmpty()) {
            etCustomerName.setError("Customer name cannot be empty");
            etCustomerName.requestFocus();
            return;
        }

        if (mobile.length() != 10 || !mobile.matches("\\d{10}")) {
            etMobileNumber.setError("Mobile number must be exactly 10 digits");
            etMobileNumber.requestFocus();
            return;
        }

        int selectedMealId = rgMealType.getCheckedRadioButtonId();
        if (selectedMealId == -1) {
            Toast.makeText(this, "Please select a meal type", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton selectedRadioButton = findViewById(selectedMealId);
        String mealType = selectedRadioButton.getText().toString();

        ArrayList<String> selectedItems = new ArrayList<>();
        double totalBill = 0.0;

        if (cbPizza.isChecked()) {
            selectedItems.add("Pizza (₹250)");
            totalBill += 250;
        }
        if (cbBurger.isChecked()) {
            selectedItems.add("Burger (₹150)");
            totalBill += 150;
        }
        if (cbSandwich.isChecked()) {
            selectedItems.add("Sandwich (₹120)");
            totalBill += 120;
        }
        if (cbSoftDrink.isChecked()) {
            selectedItems.add("Soft Drink (₹60)");
            totalBill += 60;
        }

        if (selectedItems.isEmpty()) {
            Toast.makeText(this, "Please select at least one food item", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
        intent.putExtra("CUSTOMER_NAME", name);
        intent.putExtra("MOBILE_NUMBER", mobile);
        intent.putExtra("MEAL_TYPE", mealType);
        intent.putStringArrayListExtra("SELECTED_ITEMS", selectedItems);
        intent.putExtra("TOTAL_BILL", totalBill);

        startActivity(intent);
    }
}

