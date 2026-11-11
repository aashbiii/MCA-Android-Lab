package com.example.librarymanagement;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewDetailsActivity extends AppCompatActivity {

    TextView tvDetails;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        tvDetails = findViewById(R.id.tvDetails);

        db = new DatabaseHelper(this);

        Cursor cursor = db.getBooks();

        StringBuilder data = new StringBuilder();

        while (cursor.moveToNext()) {

            data.append("Book ID : ")
                    .append(cursor.getString(0))
                    .append("\n");

            data.append("Book Name : ")
                    .append(cursor.getString(1))
                    .append("\n");

            data.append("Author : ")
                    .append(cursor.getString(2))
                    .append("\n");

            data.append("Publisher : ")
                    .append(cursor.getString(3))
                    .append("\n");

            data.append("Published Year : ")
                    .append(cursor.getString(4))
                    .append("\n");

            data.append("Price : ")
                    .append(cursor.getString(5))
                    .append("\n");

            data.append("Stock : ")
                    .append(cursor.getString(6))
                    .append("\n\n");
        }

        cursor.close();

        tvDetails.setText(data.toString());
    }
}