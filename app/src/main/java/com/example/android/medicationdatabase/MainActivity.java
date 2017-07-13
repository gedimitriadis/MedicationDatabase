package com.example.android.medicationdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.example.android.medicationdatabase.data.MedContract;
import com.example.android.medicationdatabase.data.MedDbHelper;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.widget.Toast.makeText;
import static com.example.android.medicationdatabase.data.MedContract.*;

public class MainActivity extends AppCompatActivity {

    private MedDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new MedDbHelper(this);
        insertMed();
        readMedPill();
    }

    private void insertMed(){
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MedEntry.COLUMN_MED_NAME, "Aspirin" );
        values.put(MedEntry.COLUMN_MED_TYPE, MedEntry.TYPE_PILL);
        values.put(MedEntry.COLUMN_MED_QUANTITY,1);
        values.put(MedEntry.COLUMN_MED_FREQUENCY, 2);
        values.put(MedEntry.COLUMN_MED_DURATION, "3 days");


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(MedEntry.TABLE_NAME, null, values);
        if (newRowId != -1) {
            makeText(getApplicationContext(), "Medication saved with ID: " + newRowId, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private Cursor readMedPill(){
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = { MedEntry.COLUMN_MED_NAME};
        String selection = MedEntry.COLUMN_MED_TYPE + "=?";
        String[] selectionArgs = new String[] { MedEntry.TYPE_PILL};

        Cursor cursor = db.query(MedEntry.TABLE_NAME, projection,
                selection, selectionArgs,
                null, null, null);
        return cursor;
    }



}
