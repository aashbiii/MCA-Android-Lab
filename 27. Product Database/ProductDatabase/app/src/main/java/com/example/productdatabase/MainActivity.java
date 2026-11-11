package com.example.productdatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etProduct;
    ListView listView;
    GridView gridView;

    DatabaseHelper db;
    ArrayList<String> products;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProduct = findViewById(R.id.etProduct);
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        db = new DatabaseHelper(this);

        showProducts();
    }

    public void addProduct(View view) {

        String product = etProduct.getText().toString();

        if (product.isEmpty()) {
            Toast.makeText(this, "Enter Product Name", Toast.LENGTH_SHORT).show();
            return;
        }

        db.insertProduct(product);

        Toast.makeText(this, "Product Inserted", Toast.LENGTH_SHORT).show();

        etProduct.setText("");

        showProducts();
    }

    private void showProducts() {

        products = new ArrayList<>();

        Cursor cursor = db.getProducts();

        while (cursor.moveToNext()) {
            products.add(cursor.getString(1));
        }

        cursor.close();

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                products
        );

        listView.setAdapter(adapter);
        gridView.setAdapter(adapter);
    }
}