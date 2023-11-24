package com.ass3.i200547_i202433;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity9 extends AppCompatActivity {

    ImageButton l1;
    ImageButton l2;
    ImageButton l3;
    ImageButton l4;
    ImageButton l5;
    ImageButton l6;
    EditText r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        l1 = (ImageButton) findViewById(R.id.image);
        l2 = (ImageButton) findViewById(R.id.call);
        l3 = (ImageButton) findViewById(R.id.video);
        l4 = (ImageButton) findViewById(R.id.cam);
        l5 = (ImageButton) findViewById(R.id.phot);
        l6 = (ImageButton) findViewById(R.id.file);
        r1 = (EditText) findViewById(R.id.reply);


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity4();
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity5();
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity6();
            }
        });


    }

    private void Activity6() {
        Intent intent = new Intent(this, MainActivity17.class);
        startActivity(intent);
    }

    private void Activity5() {
        Intent intent = new Intent(this, MainActivity16.class);
        startActivity(intent);
    }

    private void Activity4() {
        Intent intent = new Intent(this, MainActivity17.class);
        startActivity(intent);
    }

    private void Activity3() {
        Intent intent = new Intent(this, MainActivity15.class);
        startActivity(intent);
    }

    private void Activity2() {
        Intent intent = new Intent(this, MainActivity18.class);
        startActivity(intent);
    }

    private void Activity1() {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }

}