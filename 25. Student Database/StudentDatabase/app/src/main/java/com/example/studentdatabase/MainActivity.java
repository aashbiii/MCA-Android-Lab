package com.example.studentdatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        db = new DatabaseHelper(this);
    }

    public void addStudent(View view) {

        String name = etName.getText().toString();
        String age = etAge.getText().toString();

        if (name.isEmpty() || age.isEmpty()) {
            Toast.makeText(this,
                    "Enter all details",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        boolean inserted = db.insertStudent(name, age);

        if (inserted) {
            Toast.makeText(this,
                    "Row Inserted Successfully",
                    Toast.LENGTH_SHORT).show();

            etName.setText("");
            etAge.setText("");
        }
    }

    public void viewDetails(View view) {
        startActivity(new android.content.Intent(
                this, ViewDetailsActivity.class));
    }
}