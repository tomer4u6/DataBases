//Version 1000
package com.example.tomer.databases;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    HelperDB hlp;
    EditText et_name,et_id,et_address,et_phone,et_date;

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

    public void getData1(View view) {
    }

    public void getData2(View view) {
    }
}
