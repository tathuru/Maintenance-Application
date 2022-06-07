package com.aaiaero.emaintenance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Arrays;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "people_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "formName";
    private static final String COL3 = "activityName";
    private static final String COL4 = "editTextData";
    private static final String COL5 = "switchData";
    private static final String COL6 = "spinnerData";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT," + COL3 + " TEXT," + COL4 + " TEXT," + COL5 + " TEXT," + COL6 + " TEXT" + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String formName, String activityName, String editTextData, String switchData, String spinnerData) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, formName);
        contentValues.put(COL3, activityName);
        contentValues.put(COL4, editTextData);
        contentValues.put(COL5, switchData);
        contentValues.put(COL6, spinnerData);


        Log.d(TAG, "addData: Adding " + formName + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            Log.i("Error","Data not Inserted");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed in
     * @param formName
     * @return
     */

    public Cursor getItemID(String formName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + formName + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Updates the name field
     * @param newName
     * @param id
     * @param oldName
     */
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * @param id
     * @param formName
     */
    public void deleteName(int id, String formName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + formName + "'" ;
        //Log.d(TAG, "deleteName: query: " + query);
        //Log.d(TAG, "deleteName: Deleting " + formName + " from database.");
        db.execSQL(query);
    }




    public String[] getCompleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //String strID = Integer.toString(id);
        String query = "SELECT " + COL2 + "," + COL3 + "," + COL4 + "," + COL5 + "," + COL6 + " FROM " + TABLE_NAME +
                " WHERE " + COL1 + " = '" + id + "'";
        Cursor cursor = db.rawQuery(query, null);
        Log.d(TAG, "deleteName: query: " + query);

        //SQLiteDatabase db = this.getWritableDatabase();
        //Cursor cursor = db.rawQuery(selectQuery, null);
        String[] data = {"","","","",""};
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Contact contact = new Contact();
                //contact.setID(Integer.parseInt(cursor.getString(0)));
                data[0] = cursor.getString(0);//formName
                data[1] = cursor.getString(1);//Activity Name
                data[2] = cursor.getString(2);// Edit Text Data
                data[3] = cursor.getString(3);// Switch Data
                data[4] = cursor.getString(4);// Spinner Data
                //contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                //contactList.add(contact);
            } while (cursor.moveToNext());
        }


        //String[] completeItem = {"completeItem"," "};
        //String[] completeItem = {data.getString(0), data.getString(1),data.getString(2)};
        Log.i("DB Values", Arrays.toString(data));
        // return contact  "," + COL3 + "," + COL4 +
        return data;
    }

}
