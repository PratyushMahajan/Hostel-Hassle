package com.example.serviceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;
import com.google.api.services.sheets.v4.model.ValueRange;


import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity
{
    TextView createaccount;
    EditText email;
    EditText password;
    MaterialButton loginbtn;
    List<List<Object>> rows2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity_main);


        createaccount = findViewById(R.id.create);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        loginbtn = findViewById(R.id.loginbtn);
//        rows2.get(0).get(1);

        //admin and admin
        createaccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    readDataFromGoogleSheet();
                }
                if(email.getText().toString().equals(""))
                {
                    //error
                    email.setError("This Field is Mandatory");
                }
                if(password.getText().toString().equals(""))
                {
                    //error
                    password.setError("This Field is Mandatory");
                }
//                else if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
//                {
//                    //correct
//                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(LoginActivity.this, Dashboard.class);
//                    startActivity(intent);
//                }

            }
        });
    }
    private void readDataFromGoogleSheet()
    {
        String spreadsheetId = "1Gw2MFn-NokjkOA_M995-mVPonGhBK1eqADsnIHl399g";
        String range = "Sheet1!A:Z";
        String apiKey = "AIzaSyAtB0JJF5JEcr3gCW6W_wz2AHgtBYhGBmk";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sheets.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        com.example.serviceapp.SheetsService sheetsService;
        sheetsService = retrofit.create(com.example.serviceapp.SheetsService.class);

        Call<ValueRange>call = sheetsService.getValues(spreadsheetId, range, apiKey);
        call.enqueue(new Callback<ValueRange>() {
            @Override
            public void onResponse(@NonNull Call<ValueRange> call, @NonNull Response<ValueRange> response)
            {
                //try {
                System.out.println(response.toString());
                ValueRange values = response.body();
                List<List<Object>> rows = values.getValues();
                System.out.println(rows);
                rows2=rows;
                int flag=0;
                for(int i=0; i<rows2.size(); i++)
                {
                    if(email.getText().toString().equals(rows2.get(i).get(0).toString())
                            && password.getText().toString().equals(rows2.get(i).get(3).toString()) )
                    {
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                        startActivity(intent);
                        flag = 1;
                    }
                }
                if(flag == 0)
                {
                    Toast.makeText(LoginActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }



                // Process the rows here
                //System.out.println(rows.toString());
                // Toast.makeText(MainActivity.this, rows.get(1).get(0).toString(), Toast.LENGTH_SHORT).show();
                //}
//                catch (AssertionError a){
//                    System.out.println(a.getMessage());
//                    Toast.makeText(MainActivity.this, a.getMessage(), Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(@NonNull Call<ValueRange> call, @NonNull Throwable t) {
                Toast.makeText(LoginActivity.this, "Unable to fetch data", Toast.LENGTH_SHORT).show();
                // Handle error
            }
        });


    }
}