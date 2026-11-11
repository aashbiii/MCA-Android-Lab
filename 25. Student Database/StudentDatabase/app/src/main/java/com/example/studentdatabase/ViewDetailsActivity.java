package com.example.studentdatabase;

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

        Cursor cursor = db.getStudents();

        StringBuilder data = new StringBuilder();

        while (cursor.moveToNext()) {

            data.append("ID : ")
                    .append(cursor.getString(0))
                    .append("\n");

            data.append("Name : ")
                    .append(cursor.getString(1))
                    .append("\n");

            data.append("Age : ")
                    .append(cursor.getString(2))
                    .append("\n\n");
        }

        cursor.close();

        tvDetails.setText(data.toString());
    }
}