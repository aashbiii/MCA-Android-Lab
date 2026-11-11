package com.example.asynchronoustask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView statusText;
    Button startButton;
    ExecutorService executor;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        startButton = findViewById(R.id.startButton);

        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void startTask(View view) {

        // Disable button
        startButton.setEnabled(false);
        startButton.setText("Task Running...");
        startButton.setAlpha(0.5f);

        statusText.setText("Task is running...");

        executor.execute(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            handler.post(() -> {

                statusText.setText("Task completed!");

                // Enable button again
                startButton.setEnabled(true);
                startButton.setText("Start Task");
                startButton.setAlpha(1.0f);
            });
        });
    }

    @Override
    protected void onDestroy() {
        executor.shutdown();
        super.onDestroy();
    }
}