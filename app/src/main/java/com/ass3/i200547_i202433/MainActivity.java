package com.ass3.i200547_i202433;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    ProgressBar progressBar;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        b1 = (Button) findViewById(R.id.eigh);
        b2 = (Button) findViewById(R.id.svn);
        b3 = (Button) findViewById(R.id.nin);
        e1 = (EditText) findViewById(R.id.f);
        e2 = (EditText) findViewById(R.id.sx);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity2();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity3();
            }
        });
    }

        private void Activity3 () {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }

        public void Activity2 () {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }

}