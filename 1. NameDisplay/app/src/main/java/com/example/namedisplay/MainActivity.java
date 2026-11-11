package com.example.namedisplay;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayDetails(View view) {
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        TextView tv = findViewById(R.id.tvDisplayResult);
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        if (!name.isEmpty() && !email.isEmpty())
            tv.setText("Name : " + name + "\nEmail : " + email);
        else tv.setText("Please enter both name and email.");
    }
}
