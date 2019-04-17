package com.gamecodeschool.agedatabasepart2

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataManager(context: Context) {

    // This is the actual database
    private val db: SQLiteDatabase

    init {
        // Create an instance of our internal
        // CustomSQLiteOpenHelper class
        val helper = CustomSQLiteOpenHelper(context)
        // Get a writable database
        db = helper.writableDatabase
    }

    companion object {
        /*
        Next we have a const string for
        each row/table that we need to refer to both
        inside and outside this class
        */

        const val TABLE_ROW_ID = "_id"
        const val TABLE_ROW_NAME = "name"
        const val TABLE_ROW_AGE = "age"

        /*
        Next we have a private static final strings for
        each row/table that we need to refer to just
        inside this class
        */

        private const val DB_NAME = "address_book_db"
        private const val DB_VERSION = 1
        private const val TABLE_N_AND_A = "names_and_addresses"
    }



    // Here are all our helper methods

    // Insert a record
    fun insert(name: String, age: String) {
        // Add all the details to the table
        val query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_AGE +
                ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + age + "'" +
                ");"

        Log.i("insert() = ", query)

        db.execSQL(query)
    }

    // Delete a record
    fun delete(name: String) {

        // Delete the details from the table
        // if already exists
        val query = "DELETE FROM " + TABLE_N_AND_A +
                " WHERE " + TABLE_ROW_NAME +
                " = '" + name + "';"

        Log.i("delete() = ", query)

        db.execSQL(query)

    }

    // Get all the records
    fun selectAll(): Cursor {
        return db.rawQuery("SELECT *" + " from " +
                TABLE_N_AND_A, null)
    }

    // Find a specific record
    fun searchName(name: String): Cursor {
        val query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_AGE +
                " from " +
                TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';"

        Log.i("searchName() = ", query)

        return db.rawQuery(query, null)
    }

    // This class is created when our DataManager is initialized
    private inner class CustomSQLiteOpenHelper(
            context: Context)
        : SQLiteOpenHelper(
            context, DB_NAME,
            null, DB_VERSION) {

        // This function only runs the first
        // time the database is created
        override fun onCreate(db: SQLiteDatabase) {

            // Create a table for photos and all their details
            val newTableQueryString = ("create table "
                    + TABLE_N_AND_A + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_NAME
                    + " text not null,"
                    + TABLE_ROW_AGE
                    + " text not null);")

            db.execSQL(newTableQueryString)
        }

        // This method only runs when we increment DB_VERSION
        // We will look at this in chapter 26
        override fun onUpgrade(db: SQLiteDatabase,
                               oldVersion: Int,
                               newVersion: Int) {

        }

    }

}
