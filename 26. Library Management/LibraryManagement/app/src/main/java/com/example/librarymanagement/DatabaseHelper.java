package com.example.librarymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "LibraryDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE book(" +
                        "bookid TEXT PRIMARY KEY," +
                        "bookname TEXT," +
                        "author TEXT," +
                        "publisher TEXT," +
                        "year INTEGER," +
                        "price REAL," +
                        "stock INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS book");
        onCreate(db);
    }

    public boolean insertBook(
            String id,
            String name,
            String author,
            String publisher,
            String year,
            String price,
            String stock) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("bookid", id);
        values.put("bookname", name);
        values.put("author", author);
        values.put("publisher", publisher);
        values.put("year", year);
        values.put("price", price);
        values.put("stock", stock);

        long result = db.insert(
                "book",
                null,
                values
        );

        return result != -1;
    }

    public Cursor getBooks() {

        SQLiteDatabase db = getReadableDatabase();

        return db.rawQuery(
                "SELECT * FROM book",
                null
        );
    }
}