package com.example.sqlitecrud.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sqlitecrud.model.ResponseRoute;
import com.example.sqlitecrud.model.TeachersModel;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "teachers_data";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "teachers";
    private static final String TABLE_MAP = "maps";
    private static final String MAP_ID = "id";
    private static final String MAP_USERNAME = "username";
    private static final String MAP_LATITUDE = "latitude";
    private static final String MAP_LONGITUDE = "longitude";




    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "name";
    private static final String KEY_COURSE = "course";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";

    private static final String CREATE_TABLE_TEACHERS = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_FIRSTNAME + " TEXT NOT NULL, " +
            KEY_COURSE + " TEXT NOT NULL, " +
            KEY_EMAIL + " TEXT NOT NULL, " +
            KEY_PHONE + " VARCHAR " +
            "); ";


    private static final String CREATE_TABLE_MAPS = "CREATE TABLE "
            + TABLE_MAP + "(" + MAP_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MAP_USERNAME + " TEXT NOT NULL, " +
            MAP_LATITUDE + " TEXT NOT NULL, " +
            MAP_LONGITUDE + " TEXT NOT NULL " +
            "); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table teachers: ", CREATE_TABLE_TEACHERS);
        Log.d( "DatabaseHelperMaps: ", CREATE_TABLE_MAPS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TEACHERS);
        db.execSQL(CREATE_TABLE_MAPS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MAP + "'");

        //create new table
        onCreate(db);
    }


    ///ADD DATA TO TABLE
    public long addMap(String username, String latitude, String longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(MAP_USERNAME, username);
        values.put(MAP_LATITUDE, latitude);
        values.put(MAP_LONGITUDE, longitude);
        //insert row in table
        long insert = db.insert(TABLE_MAP, null, values);

        return insert;
    }

    public long addTeachersDetail(String name, String course, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        values.put(KEY_COURSE, course);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PHONE, phone);
        //insert row in table
        long insert = db.insert(TABLE_USER, null, values);

        return insert;
    }


    ///END ADD TABLE


    ///GET DATA FROM TABLE
    public ArrayList<TeachersModel> getAllTeachers() {
        ArrayList<TeachersModel> teachersModelArrayList = new ArrayList<TeachersModel>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                TeachersModel teachersModel = new TeachersModel();
                teachersModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                teachersModel.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));
                teachersModel.setCourse(c.getString(c.getColumnIndex(KEY_COURSE)));
                teachersModel.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                teachersModel.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));
                // adding to list
                teachersModelArrayList.add(teachersModel);
            } while (c.moveToNext());
        }
        return teachersModelArrayList;
    }

    public ArrayList<ResponseRoute> getAllMaps() {
        ArrayList<ResponseRoute> mapModelArrayList = new ArrayList<ResponseRoute>();

        String selectQuery = "SELECT  * FROM " + TABLE_MAP;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ResponseRoute mapResponseModel = new ResponseRoute();
//                mapResponseModel.setId(c.getInt(c.getColumnIndex(MAP_ID)));
//                mapResponseModel.setName(c.getString(c.getColumnIndex(MAP_USERNAME)));
//                mapResponseModel.setCourse(c.getString(c.getColumnIndex(MAP_LATITUDE)));
//                mapResponseModel.setEmail(c.getString(c.getColumnIndex(MAP_LONGITUDE)));
                // adding to list
                mapModelArrayList.add(mapResponseModel);
            } while (c.moveToNext());
        }
        return mapModelArrayList;
    }

    ///endd GETDATA


    public int updateTeachers(int id, String name, String course, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        values.put(KEY_COURSE, course);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PHONE, phone);
        // update row in table base on students.is value
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    public int updateMap(int id, String username, String latitude, String longitude) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values
        ContentValues values = new ContentValues();
        values.put(MAP_USERNAME, username);
        values.put(MAP_LATITUDE, latitude);
        values.put(MAP_LONGITUDE, longitude);
        // update row in table base on students.is value
        return db.update(TABLE_MAP, values, MAP_ID + " = ?",
                new String[]{String.valueOf(id)});
    }




    public void deleteUSer(int id) {

        // delete row in table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public void deleteMaps(int id) {

        // delete row in table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MAP, MAP_ID + " = ?",
                new String[]{String.valueOf(id)});
    }






}
