package com.ass3.i200547_i202433;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity18 extends AppCompatActivity {

    ImageButton i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);

        i1 = (ImageButton) findViewById(R.id.endCall);


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity1();
            }
        });

    }
    private void Activity1() {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }
}

