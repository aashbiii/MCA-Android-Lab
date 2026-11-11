package com.example.loginregistration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        db = new DatabaseHelper(this);
    }

    public void login(View view) {

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this,
                    "Enter all details",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        boolean result = db.loginUser(user, pass);

        if (result) {
            Toast.makeText(this,
                    "Login Successful",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,
                    "Invalid Username or Password",
                    Toast.LENGTH_SHORT).show();
        }
    }
}