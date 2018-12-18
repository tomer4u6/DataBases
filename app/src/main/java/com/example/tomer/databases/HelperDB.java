package com.example.tomer.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABAS_NAME = "dbexam.db";
    private static int DATABASE_VERSION = 1000;
    String strCreate,strDelete;
    public HelperDB(Context context) {
        super(context, DATABAS_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        strCreate="CREATE TABLE "+Student.TABLE_STUDENT;
        strCreate+=" ("+Student.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+Student.FULL_NAME+" TEXT,";
        strCreate+=" "+Student.ID_NUMBER+" TEXT,";
        strCreate+=");";
        sqLiteDatabase.execSQL(strCreate);


        strCreate="CREATE TABLE "+StudentInfo.TABLE_STUDENTINFO;
        strCreate+=" ("+StudentInfo.KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+StudentInfo.FULL_ADDRESS+" TEXT,";
        strCreate+=" "+StudentInfo.PHONE_NUMBER+" TEXT,";
        strCreate+=" "+StudentInfo.BIRTH_DATE+" TEXT";
        strCreate+=");";
        sqLiteDatabase.execSQL(strCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        strDelete = "DROP TABLE IF EXISTS "+Student.TABLE_STUDENT;
        sqLiteDatabase.execSQL(strDelete);
        strDelete = "DROP TABLE IF EXISTS "+StudentInfo.TABLE_STUDENTINFO;
        sqLiteDatabase.execSQL(strDelete);

        onCreate(sqLiteDatabase);

    }
}
