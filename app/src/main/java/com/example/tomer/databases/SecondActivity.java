package com.example.tomer.databases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

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
}
