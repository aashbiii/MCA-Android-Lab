package com.example.sensorsapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;

    Sensor lightSensor;
    Sensor pressureSensor;
    Sensor humiditySensor;

    TextView lightText;
    TextView pressureText;
    TextView humidityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightText = findViewById(R.id.lightText);
        pressureText = findViewById(R.id.pressureText);
        humidityText = findViewById(R.id.humidityText);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        if (lightSensor == null) {
            lightText.setText("Light Sensor Not Available");
        }

        if (pressureSensor == null) {
            pressureText.setText("Pressure Sensor Not Available");
        }

        if (humiditySensor == null) {
            humidityText.setText("Humidity Sensor Not Available");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (lightSensor != null) {
            sensorManager.registerListener(
                    this,
                    lightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL
            );
        }

        if (pressureSensor != null) {
            sensorManager.registerListener(
                    this,
                    pressureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL
            );
        }

        if (humiditySensor != null) {
            sensorManager.registerListener(
                    this,
                    humiditySensor,
                    SensorManager.SENSOR_DELAY_NORMAL
            );
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

            float light = event.values[0];

            lightText.setText(
                    "Light: " + light + " lux"
            );
        }

        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {

            float pressure = event.values[0];

            pressureText.setText(
                    "Pressure: " + pressure + " hPa"
            );
        }

        if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {

            float humidity = event.values[0];

            humidityText.setText(
                    "Humidity: " + humidity + " %"
            );
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not required
    }
}