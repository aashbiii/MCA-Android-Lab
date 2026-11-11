package com.example.flashlightapp;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    TextView statusText;
    CameraManager cameraManager;
    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        statusText = findViewById(R.id.statusText);

        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        toggleButton.setOnCheckedChangeListener((button, isChecked) -> {
            try {
                cameraManager.setTorchMode(cameraId, isChecked);

                if (isChecked) {
                    statusText.setText("Flashlight is ON");
                } else {
                    statusText.setText("Flashlight is OFF");
                }

            } catch (Exception e) {
                statusText.setText("Flashlight is OFF");
            }
        });
    }
}