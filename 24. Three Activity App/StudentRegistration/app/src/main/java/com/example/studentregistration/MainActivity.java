package com.example.studentregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
    }

    public void nextPage(View view) {

        String name = etName.getText().toString();
        String age = etAge.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("age", age);

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
            etName.setText("");
            etAge.setText("");
            return true;
        }

        if (item.getItemId() == R.id.menuExit) {
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}