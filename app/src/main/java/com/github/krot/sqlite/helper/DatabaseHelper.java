package com.github.krot.sqlite.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.github.krot.game.Operation;
import com.github.krot.game.Operator;
import com.github.krot.game.Round;
import com.github.krot.utils.RoundsProducer;

import java.util.ArrayList;

import static com.github.krot.game.Operation.valueOf;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "krotDatabase";

    // Table Names
    private static final String TABLE_SYSTEM_PROPERTIES = "system_properties";
    private static final String TABLE_OPERATORS = "operators";
    private static final String TABLE_ROUNDS = "rounds";

    // SYSTEM PROPERTIES TABLE- column names
    private static final String COLUMN_PROPERTY = "property";
    private static final String COLUMN_VALUE = "value";

    // OPERATORS TABLE- column names
    private static final String COLUMN_OPERATOR_ID = "operation_id";
    private static final String COLUMN_OPERATION = "operation";
    private static final String COLUMN_OPERAND = "operand";

    // ROUNDS TABLE- column names
    private static final String COLUMN_ROUND_ID = "round_id";
    private static final String COLUMN_INIT_VALUE = "init_value";
    private static final String COLUMN_TARGET_VALUE = "target_value";

    // Table Create Statements
    // SYSTEM_PROPERTIES table create statement
    private static final String CREATE_TABLE_SYSTEM_PROPERTIES = "CREATE TABLE " + TABLE_SYSTEM_PROPERTIES
            + "(" + COLUMN_PROPERTY + " TEXT PRIMARY KEY," + COLUMN_VALUE + " TEXT" + ")";

    // ROUNDS table create statement
    private static final String CREATE_TABLE_ROUNDS = "CREATE TABLE " + TABLE_ROUNDS
            + "(" + COLUMN_ROUND_ID + " INTEGER PRIMARY KEY," + COLUMN_INIT_VALUE + " REAL," +
            COLUMN_TARGET_VALUE + " REAL" + ")";

    // OPERATORS table create statement
    private static final String CREATE_TABLE_OPERATORS = "CREATE TABLE " + TABLE_OPERATORS
            + "(" + COLUMN_OPERATOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ROUND_ID + " INTEGER," +
            COLUMN_OPERATION + " TEXT," + COLUMN_OPERAND + " INTEGER" + ")";

    private static DatabaseHelper helper;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static void init(Context context) {
        helper = new DatabaseHelper(context);
    }

    public static DatabaseHelper getHelper() {
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_SYSTEM_PROPERTIES);
        db.execSQL(CREATE_TABLE_ROUNDS);
        db.execSQL(CREATE_TABLE_OPERATORS);

        for (Round round : RoundsProducer.INSTANCE.getRounds()) {
            addRound(db, round);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putProperty(String property, String value) {
        if (getProperty(property) == null) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_PROPERTY, property);
            values.put(COLUMN_VALUE, value);

            SQLiteDatabase db = null;
            try {
                db = this.getWritableDatabase();
                db.insert(TABLE_SYSTEM_PROPERTIES, null, values);
            } finally {
                if (db != null) {
                    db.close();
                }
            }
        } else {
            updateProperty(property, value);
        }
    }

    private void updateProperty(String property, String value) {
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.execSQL("UPDATE " + TABLE_SYSTEM_PROPERTIES
                            + " SET " + COLUMN_VALUE + " = ?"
                            + " WHERE " + COLUMN_PROPERTY + " = ?",
                    new String [] {value, property});
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }

    public String getProperty(String property) {
        String value = null;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = this.getWritableDatabase();
            cursor = db.rawQuery("SELECT * from " + TABLE_SYSTEM_PROPERTIES
                            + " WHERE " + COLUMN_PROPERTY + " = ?",
                    new String[] { property });

            if (cursor.moveToFirst()) {
                value = cursor.getString(cursor.getColumnIndex(COLUMN_VALUE));
            }
        } finally {
            if (db != null) {
                db.close();
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return value;
    }

    private void addRound(SQLiteDatabase db, Round round) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ROUND_ID, round.getId());
        values.put(COLUMN_INIT_VALUE, round.getInitValue());
        values.put(COLUMN_TARGET_VALUE, round.getTargetValue());

        db.insert(TABLE_ROUNDS, null, values);

        for (Operator operator : round.getOperators()) {
            values = new ContentValues();
            values.put(COLUMN_ROUND_ID, round.getId());
            values.put(COLUMN_OPERATION, operator.getOperation().toString());
            values.put(COLUMN_OPERAND, operator.getOperand());
            db.insert(TABLE_OPERATORS, null, values);
        }
    }

    public Round findRoundById(int roundId) {
        Round round = null;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = this.getWritableDatabase();
            cursor = db.rawQuery("SELECT * from " + TABLE_ROUNDS
                            + " WHERE " + COLUMN_ROUND_ID + " = ?",
                    new String[] { String.valueOf(roundId) });

            if (cursor.moveToFirst()) {
                float initValue = cursor.getFloat(cursor.getColumnIndex(COLUMN_INIT_VALUE));
                float targetValue = cursor.getFloat(cursor.getColumnIndex(COLUMN_TARGET_VALUE));
                round = new Round(roundId, initValue, targetValue, new ArrayList<Operator>());

                cursor = db.rawQuery("SELECT * from " + TABLE_OPERATORS
                                + " WHERE " + COLUMN_ROUND_ID + " = ?",
                        new String[] { String.valueOf(roundId) });

                if (cursor.moveToFirst()) {
                    do {
                        Operation operation = valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_OPERATION)));
                        int operand = cursor.getInt(cursor.getColumnIndex(COLUMN_OPERAND));
                        Operator operator = new Operator(operation, operand);

                        round.getOperators().add(operator);
                    } while (cursor.moveToNext());
                }
            }
        } finally {
            if (db != null) {
                db.close();
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return round;
    }
}
