package com.ass3.i200547_i202433;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity12 extends AppCompatActivity {

    ImageButton i1, i2;
    EditText e1, e2, e3, e4;
    Button b1;
    Uri imageUri, vidUri;
    private String myUri = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        i1 = (ImageButton) findViewById(R.id.c1);
        i2 = (ImageButton) findViewById(R.id.c2);
        e1 = (EditText) findViewById(R.id.r2);
        e2 = (EditText) findViewById(R.id.r4);
        e3 = (EditText) findViewById(R.id.r6);
        e4 = (EditText) findViewById(R.id.r8);
        b1 = (Button) findViewById(R.id.b1);
    }
}