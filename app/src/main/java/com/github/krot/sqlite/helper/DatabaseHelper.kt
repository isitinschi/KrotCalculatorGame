package com.github.krot.sqlite.helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        // creating required tables
        db.execSQL(CREATE_TABLE_SYSTEM_PROPERTIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) { }

    fun putProperty(property: String, value: String) {
        if (getProperty(property) == null) {
            val values = ContentValues()
            values.put(COLUMN_PROPERTY, property)
            values.put(COLUMN_VALUE, value)

            this.writableDatabase.use { db ->
                db.insert(TABLE_SYSTEM_PROPERTIES, null, values)
            }
        } else {
            updateProperty(property, value)
        }
    }

    private fun updateProperty(property: String, value: String) {
        this.writableDatabase.use { db ->
            db.execSQL("UPDATE $TABLE_SYSTEM_PROPERTIES"
                    + " SET $COLUMN_VALUE = ?"
                    + " WHERE $COLUMN_PROPERTY = ?",
                    arrayOf(value, property))
        }
    }

    fun getProperty(property: String): String? {
        this.writableDatabase.use { db ->
            db.rawQuery("SELECT * from $TABLE_SYSTEM_PROPERTIES"
                    + " WHERE $COLUMN_PROPERTY = ?",
                    arrayOf(property)).use { cursor ->
                return if (cursor.moveToFirst()) cursor.getString(cursor.getColumnIndex(COLUMN_VALUE)) else null
            }
        }
    }

    companion object {
        lateinit var INSTANCE: DatabaseHelper

        fun init(context: Context) {
            INSTANCE = DatabaseHelper(context)
        }

        // Database Version
        private val DATABASE_VERSION = 1

        // Database Name
        private val DATABASE_NAME = "krotDatabase"

        // Table Names
        private val TABLE_SYSTEM_PROPERTIES = "system_properties"

        // SYSTEM PROPERTIES TABLE- column names
        private val COLUMN_PROPERTY = "property"
        private val COLUMN_VALUE = "value"

        // Table Create Statements
        // SYSTEM_PROPERTIES table create statement
        private val CREATE_TABLE_SYSTEM_PROPERTIES = ("CREATE TABLE $TABLE_SYSTEM_PROPERTIES"
                + "($COLUMN_PROPERTY TEXT PRIMARY KEY,$COLUMN_VALUE TEXT" + ")")
    }
}
