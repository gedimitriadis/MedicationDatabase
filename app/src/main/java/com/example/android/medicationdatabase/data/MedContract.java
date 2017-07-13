package com.example.android.medicationdatabase.data;

import android.provider.BaseColumns;

/**
 * Created by georgeD on 13/07/2017.
 */

public final class MedContract implements BaseColumns {


    public static abstract class MedEntry implements BaseColumns {
        //table name
        public static final String TABLE_NAME = "medication";
        //table columns
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_MED_NAME = "medicine";
        public static final String COLUMN_MED_TYPE = "type";
        public static final String COLUMN_MED_QUANTITY = "quantity";
        public static final String COLUMN_MED_FREQUENCY = "frequency";
        public static final String COLUMN_MED_DURATION = "duration";

        /**
         * Possible values for the type of the medicine.
         */
        public static final String TYPE_PILL = "pill";
        public static final String TYPE_SYRUP = "syrup";
    }
}
