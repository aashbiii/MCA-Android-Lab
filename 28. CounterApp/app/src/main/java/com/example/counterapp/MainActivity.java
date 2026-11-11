package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView counterText;
    Button decrementButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counterText);
        decrementButton = findViewById(R.id.decrementButton);
    }

    public void increment(View view) {
        count++;
        counterText.setText(String.valueOf(count));

        if (count >= 1) {
            decrementButton.setVisibility(View.VISIBLE);
        }
    }

    public void decrement(View view) {
        count--;

        if (count == 0) {
            decrementButton.setVisibility(View.GONE);
        }

        counterText.setText(String.valueOf(count));
    }

    public void reset(View view) {
        count = 0;
        counterText.setText(String.valueOf(count));
        decrementButton.setVisibility(View.GONE);
    }
}