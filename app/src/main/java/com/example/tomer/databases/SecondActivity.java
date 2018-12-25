package com.example.tomer.databases;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    Spinner spr;
    ArrayAdapter<CharSequence> sprAdp;
    ArrayAdapter lvAdp;
    ArrayList<String> tbl;
    SQLiteDatabase db;
    HelperDB hlp;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.lv);
        spr = (Spinner)findViewById(R.id.spr);

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();

        sprAdp = ArrayAdapter.createFromResource(this,R.array.spinner_items,R.layout.support_simple_spinner_dropdown_item);
        sprAdp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spr.setAdapter(sprAdp);
        spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tbl = new ArrayList<>();
                if(i == 0){
                    db = hlp.getWritableDatabase();
                    c = db.query(Student.TABLE_STUDENT,null,null,null,null,null,null);
                    int col1 = c.getColumnIndex("_id");
                    int col2 = c.getColumnIndex("FullName");
                    int col3 = c.getColumnIndex("IdNumber");
                    c.moveToFirst();
                    while(!c.isAfterLast()){
                        String fullname = c.getString(col2);
                        String idnumber = c.getString(col3);
                        tbl.add(fullname+" | "+idnumber);
                        c.moveToNext();
                    }
                    c.close();
                    db.close();

                    setAdapter();
                }
                if(i == 1){
                    db = hlp.getWritableDatabase();
                    c = db.query(StudentInfo.TABLE_STUDENTINFO,null,null,null,null,null,null);
                    int col1 = c.getColumnIndex("_id");
                    int col2 = c.getColumnIndex("FullAddress");
                    int col3 = c.getColumnIndex("PhoneNumber");
                    int col4 = c.getColumnIndex("BirthDate");
                    c.moveToFirst();
                    while(!c.isAfterLast()){
                        String fulladdress = c.getString(col2);
                        String phonenumber = c.getString(col3);
                        String birthdate = c.getString(col4);
                        tbl.add(fulladdress+" | "+phonenumber+" | "+birthdate);
                        c.moveToNext();
                    }
                    c.close();
                    db.close();

                    setAdapter();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



    private void setAdapter() {
        lvAdp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,tbl);
        lv.setAdapter(lvAdp);
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
            Intent t = new Intent(this, MainActivity.class);
            startActivity(t);
        }
        return super.onOptionsItemSelected(item);
    }
}
