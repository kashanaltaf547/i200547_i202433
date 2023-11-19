package com.ass3.i200547_i202433;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    Button b2;
    Button b3;
    EditText e1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2 = (Button) findViewById(R.id.d);
        b3 = (Button) findViewById(R.id.e);
        e1 = (EditText) findViewById(R.id.c);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
    }

    private void Activity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}