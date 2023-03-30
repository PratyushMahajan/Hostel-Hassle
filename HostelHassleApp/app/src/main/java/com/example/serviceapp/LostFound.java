package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LostFound extends AppCompatActivity {

    EditText roomno, item, description;
    TextView t;
    Button submit;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lostfound);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.lostfound);

        roomno=findViewById(R.id.editText);
        description=findViewById(R.id.editText2);
        item=findViewById(R.id.editText3);
        t=findViewById(R.id.textView);
        submit=findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View v) {
                String room = roomno.getText().toString();
                String des = description.getText().toString();
                String itm = item.getText().toString();

                if(room.isEmpty()) {
                    roomno.setError("This Field is Mandatory");
                }
                if(des.isEmpty()) {
                    description.setError("This Field is Mandatory");
                }
                if(itm.isEmpty()) {
                    item.setError("This Field is Mandatory");
                }
                else{
                    Toast.makeText(LostFound.this, "Request Noted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            myClickItem(item);
            return true;
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(LostFound.this,History.class);
                startActivity(intent);
            }
        });

    }
    public void myClickItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.homepage:
                Intent intent = new Intent(LostFound.this, Dashboard.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.lostfound:
                Intent intent2 = new Intent(LostFound.this, LostFound.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.profile:
                Intent intent3 = new Intent(LostFound.this, Profile.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.history:
                Intent intent4 = new Intent(LostFound.this, History.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                finish();
                break;
        }

    }
}