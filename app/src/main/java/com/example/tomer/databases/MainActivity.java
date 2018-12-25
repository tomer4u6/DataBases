//Version 1003
package com.example.tomer.databases;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ContentValues cv;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if(st.equals("Credits")){
            Toast.makeText(this, "This app was created by Tomer Ben Ari", Toast.LENGTH_SHORT).show();
        }
        if (st.equals("Change Activity")){
            Intent t = new Intent(this, SecondActivity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }

    public void getDataStudent(View view) {
        if(et_name.getText().toString().isEmpty()||et_id.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter the data", Toast.LENGTH_SHORT).show();
        }
        else {
            cv = new ContentValues();
            name = et_name.getText().toString();
            _id = et_id.getText().toString();

            cv.put(Student.FULL_NAME, name);
            cv.put(Student.ID_NUMBER, _id);

            db = hlp.getWritableDatabase();
            db.insert(Student.TABLE_STUDENT, null, cv);
            db.close();
        }
    }

    public void getDataStudentInfo(View view) {
        if(et_date.getText().toString().isEmpty()||et_phone.getText().toString().isEmpty()||et_address.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter the data", Toast.LENGTH_SHORT).show();
        }
        else {
            cv = new ContentValues();
            address = et_address.getText().toString();
            phone = et_phone.getText().toString();
            birhtday = et_date.getText().toString();

            cv.put(StudentInfo.FULL_ADDRESS, address);
            cv.put(StudentInfo.PHONE_NUMBER, phone);
            cv.put(StudentInfo.BIRTH_DATE, birhtday);

            db = hlp.getWritableDatabase();
            db.insert(StudentInfo.TABLE_STUDENTINFO, null, cv);
            db.close();
        }
    }
}
