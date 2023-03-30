package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button b;
    View edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            myClickItem(item);
            return true;
        });
        b=findViewById(R.id.button2);
        edit=findViewById(R.id.view2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                Toast.makeText(Profile.this, "Logged Out", Toast.LENGTH_SHORT).show();
            }
        });

//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
    public void myClickItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homepage:
                Intent intent = new Intent(Profile.this, Dashboard.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.lostfound:
                Intent intent2 = new Intent(Profile.this, LostFound.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.profile:
                Intent intent3 = new Intent(Profile.this, Profile.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.history:
                Intent intent4 = new Intent(Profile.this, History.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                finish();
                break;
        }

    }

}
