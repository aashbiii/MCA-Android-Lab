package com.example.librarymanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etBookId, etBookName, etAuthor, etPublisher;
    EditText etYear, etPrice, etStock;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBookId = findViewById(R.id.etBookId);
        etBookName = findViewById(R.id.etBookName);
        etAuthor = findViewById(R.id.etAuthor);
        etPublisher = findViewById(R.id.etPublisher);
        etYear = findViewById(R.id.etYear);
        etPrice = findViewById(R.id.etPrice);
        etStock = findViewById(R.id.etStock);

        db = new DatabaseHelper(this);
    }

    public void addBook(View view) {

        String id = etBookId.getText().toString();
        String name = etBookName.getText().toString();
        String author = etAuthor.getText().toString();
        String publisher = etPublisher.getText().toString();
        String year = etYear.getText().toString();
        String price = etPrice.getText().toString();
        String stock = etStock.getText().toString();

        if (id.isEmpty() || name.isEmpty() ||
                author.isEmpty() || publisher.isEmpty() ||
                year.isEmpty() || price.isEmpty() ||
                stock.isEmpty()) {

            Toast.makeText(this,
                    "Enter all details",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        boolean inserted = db.insertBook(
                id, name, author, publisher,
                year, price, stock
        );

        if (inserted) {

            Toast.makeText(this,
                    "Book Inserted Successfully",
                    Toast.LENGTH_SHORT).show();

            etBookId.setText("");
            etBookName.setText("");
            etAuthor.setText("");
            etPublisher.setText("");
            etYear.setText("");
            etPrice.setText("");
            etStock.setText("");
        }
    }

    public void viewBooks(View view) {

        Intent intent = new Intent(
                this,
                ViewDetailsActivity.class
        );

        startActivity(intent);
    }
}