package com.example.shanlunt.other_question.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shanlunt.other_question.Model.Other_QUestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanlunt on 3/21/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Languages";

    // table name
    private static final String TABLE_Languages = "Languages";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE;

        CREATE_CONTACTS_TABLE = "create table " + TABLE_Languages + "("
                + KEY_ID + " integer primary key autoincrement, " + KEY_NAME
                + " text not null);";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Languages);
        onCreate(db);
    }

    public void add(Other_QUestion lang) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, lang.getValue()); // Contact Name

        // Inserting Row
        db.insert(TABLE_Languages, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Other_QUestion getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Languages, new String[] { KEY_ID,
                        KEY_NAME }, KEY_ID + "=?", new String[] { String.valueOf(id) },
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Other_QUestion lang = new Other_QUestion(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));

        return lang;
    }

    // Getting All data
    public List<Other_QUestion> getAllvalues() {
        List<Other_QUestion> languageList = new ArrayList<Other_QUestion>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_Languages;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Other_QUestion lang = new Other_QUestion();
                lang.setId(Integer.parseInt(cursor.getString(0)));
                lang.setValue(cursor.getString(1));
                languageList.add(lang);
            } while (cursor.moveToNext());
        }

        return languageList;
    }

    // Updating single record
    public int update(Other_QUestion lang) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, lang.getValue());

        // updating row
        return db.update(TABLE_Languages, values, KEY_ID + " = ?",
                new String[] { String.valueOf(lang.getId()) });
    }
}
