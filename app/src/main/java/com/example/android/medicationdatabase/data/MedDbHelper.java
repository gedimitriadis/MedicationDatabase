package com.example.android.medicationdatabase.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.medicationdatabase.data.MedContract.MedEntry;

/**
 * Created by georgeD on 13/07/2017.
 */

public class MedDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = MedDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "remember_my_med.db";


    public MedDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the medication table
        String SQL_CREATE_MEDS_TABLE =  "CREATE TABLE " + MedEntry.TABLE_NAME + " ("
                + MedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MedEntry.COLUMN_MED_NAME + " TEXT NOT NULL, "
                + MedEntry.COLUMN_MED_TYPE + "TEXT NOT NULL, "
                + MedEntry.COLUMN_MED_QUANTITY + " INTEGER NOT NULL, "
                + MedEntry.COLUMN_MED_FREQUENCY + " INTEGER NOT NULL, "
                + MedEntry.COLUMN_MED_DURATION + " TEXT NOT NULL DEFAULT one week);";


        db.execSQL(SQL_CREATE_MEDS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //
    }
}
