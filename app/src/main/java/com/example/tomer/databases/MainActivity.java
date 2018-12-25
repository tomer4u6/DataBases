//Version 1001
package com.example.tomer.databases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    HelperDB hlp;
    EditText et_name,et_id,et_address,et_phone,et_date;
    String name,_id,address,phone,birhtday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText)findViewById(R.id.et_name);
        et_id = (EditText)findViewById(R.id.et_id);
        et_address = (EditText)findViewById(R.id.et_address);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_date = (EditText)findViewById(R.id.et_date);

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
    }

    public void getDataStudent(View view) {
        ContentValues cv = new ContentValues();
        name = et_name.getText().toString();
        _id = et_id.getText().toString();
    }

    public void getDataStudentInfo(View view) {
        ContentValues cv = new ContentValues();
        address = et_address.getText().toString();
        phone = et_phone.getText().toString();
        birhtday = et_date.getText().toString();
    }
}
