package com.example.studentregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    RadioGroup radioGroup;

    String name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        radioGroup = findViewById(R.id.radioGroup);

        name = getIntent().getStringExtra("name");
        age = getIntent().getStringExtra("age");
    }

    public void nextPage(View view) {

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return;
        }

        RadioButton radioButton = findViewById(selectedId);

        String gender = radioButton.getText().toString();

        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("gender", gender);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuClear) {
            radioGroup.clearCheck();
            return true;
        }

        if (item.getItemId() == R.id.menuExit) {
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}