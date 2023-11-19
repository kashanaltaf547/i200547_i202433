package com.ass3.i200547_i202433;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity13 extends AppCompatActivity {

    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    Button b1;
    String name, email, number, country, city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        e1 = findViewById(R.id.r2);
        e2 = findViewById(R.id.r4);
        e3 = findViewById(R.id.r6);
        e4 = findViewById(R.id.r8);
        e5 = findViewById(R.id.r10);
        b1 = findViewById(R.id.but100);

        showData();

    }
    private void showData(){
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        number = intent.getStringExtra("number");
        country = intent.getStringExtra("country");
        city = intent.getStringExtra("city");

        e1.setText(name);
        e2.setText(email);
        e3.setText(number);
        e4.setText(country);
        e5.setText(city);
    }
}