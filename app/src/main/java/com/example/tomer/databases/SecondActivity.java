package com.example.tomer.databases;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    Spinner spr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.lv);
        spr = (Spinner)findViewById(R.id.spr);
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
