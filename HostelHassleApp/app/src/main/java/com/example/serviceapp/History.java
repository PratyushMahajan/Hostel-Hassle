package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    ListView ls;
    BottomNavigationView bottomNavigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_history);

        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.history);

        ls=findViewById(R.id.ls);
        ArrayList<historyClass> a=new ArrayList<historyClass>();
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        a.add(new historyClass("Wifi Service","13/03/2023","Pending"));
        CustomAdapter ca=new CustomAdapter(History.this,R.layout.listview,a);
        ls.setAdapter(ca);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            myClickItem(item);
            return true;
        });

    }

    public void myClickItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homepage:
                Intent intent = new Intent(History.this, Dashboard.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.lostfound:
                Intent intent2 = new Intent(History.this, LostFound.class);
                startActivity(intent2);
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.profile:
                Intent intent3 = new Intent(History.this, Profile.class);
                startActivity(intent3);
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.history:
                Intent intent4 = new Intent(History.this, History.class);
                startActivity(intent4);
                overridePendingTransition(0,0);
                finish();
                break;

        }


    }
}