package com.ass3.i200547_i202433;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity14 extends AppCompatActivity {

    EditText e1;
    Button b1;
    ImageButton b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);

        e1 = (EditText) findViewById(R.id.e2);
        b1 = (Button) findViewById(R.id.e3);
        b2 = (ImageButton) findViewById(R.id.e0);


    b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}