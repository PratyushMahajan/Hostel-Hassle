package com.example.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity
{

    EditText name;
    EditText email;
    EditText contact;
    EditText password;
    EditText cpassword;
    MaterialButton signupbtn;
    TextView loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.cno);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        signupbtn = findViewById(R.id.signupbtn);
        loginbtn = findViewById(R.id.loginbtn);

        signupbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(name.getText().toString().equals(""))
                {
                    name.setError("This Field is Mandatory");
                }
                if(email.getText().toString().equals(""))
                {
                    email.setError("This Field is Mandatory");
                }
                if(contact.getText().toString().equals(""))
                {
                    contact.setError("This Field is Mandatory");
                }
                if(password.getText().toString().equals(""))
                {
                    password.setError("This Field is Mandatory");
                }
                if(cpassword.getText().toString().equals(""))
                {
                    cpassword.setError("This Field is Mandatory");
                }
                else if(password.getText().toString().equals(cpassword.getText().toString())) {
                    Toast.makeText(SignupActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    cpassword.setError("Check Password");
                }
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent1);
            }
        });
    }
}