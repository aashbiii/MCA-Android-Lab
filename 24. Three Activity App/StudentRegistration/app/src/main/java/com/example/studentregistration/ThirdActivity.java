package com.example.studentregistration;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    TextView tvDetails;
    CheckBox cbJava, cbAndroid, cbPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvDetails = findViewById(R.id.tvDetails);
        cbJava = findViewById(R.id.cbJava);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbPython = findViewById(R.id.cbPython);

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");

        tvDetails.setText(
                "Name : " + name +
                        "\nAge : " + age +
                        "\nGender : " + gender
        );
    }

    public void submit(View view) {

        String courses = "";

        if (cbJava.isChecked())
            courses += "Java ";

        if (cbAndroid.isChecked())
            courses += "Android ";

        if (cbPython.isChecked())
            courses += "Python ";

        Toast.makeText(
                this,
                "Selected Courses: " + courses,
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuClear) {

            cbJava.setChecked(false);
            cbAndroid.setChecked(false);
            cbPython.setChecked(false);

            return true;
        }

        if (item.getItemId() == R.id.menuExit) {
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}