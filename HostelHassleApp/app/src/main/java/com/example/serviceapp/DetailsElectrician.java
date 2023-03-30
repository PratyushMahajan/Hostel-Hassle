package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsElectrician extends AppCompatActivity {

    View b;
    EditText roomno, problem, bed;
    TextView t;
    Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detailselectrician);

        b=findViewById(R.id.back);
        roomno=findViewById(R.id.editText);
        problem=findViewById(R.id.editText2);
        bed=findViewById(R.id.editText3);
        t=findViewById(R.id.textView);
        submit=findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsElectrician.this, Dashboard.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View v) {
                String room = roomno.getText().toString();
                String prblm = problem.getText().toString();
                String bedno = bed.getText().toString();

                if(room.isEmpty()) {
                    roomno.setError("This Field is Mandatory");
                }
                if(prblm.isEmpty()) {
                    problem.setError("This Field is Mandatory");
                }
                if(bedno.isEmpty()) {
                    bed.setError("This Field is Mandatory");
                }
                else{
                    Toast.makeText(DetailsElectrician.this, "Service Registered", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DetailsElectrician.this,History.class);
                startActivity(intent);
            }
        });

    }
}