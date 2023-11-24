package com.ass3.i200547_i202433;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity9 extends AppCompatActivity {

    ImageButton l1;
    ImageButton l2;
    ImageButton l3;
    ImageButton l4;
    ImageButton l5;
    ImageButton l6;
    EditText r1;

    // Map to store message timestamps
    private Map<String, Long> messageTimestamps = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        l1 = findViewById(R.id.image);
        l2 = findViewById(R.id.call);
        l3 = findViewById(R.id.video);
        l4 = findViewById(R.id.cam);
        l5 = findViewById(R.id.phot);
        l6 = findViewById(R.id.file);
        r1 = findViewById(R.id.reply);

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

        // Set up a handler to simulate the receipt of a message
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                receiveMessage("This is a sample message", "18:56");
            }
        }, 3000); // Simulate a delay of 3 seconds before receiving a message
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

    private boolean isEditable(String message) {
        Long timestamp = messageTimestamps.get(message);
        if (timestamp != null) {
            long currentTime = System.currentTimeMillis();
            return (currentTime - timestamp) <= (5 * 60 * 1000); // 5 minutes in milliseconds
        }
        return false;
    }

    private void sendMultimediaMessage(final String senderId, final String receiverId, final String message, final File file) {
        new SendMessageTask().execute(senderId, receiverId, message, file.getPath());
    }

    private void receiveMessage(String message, String timestamp) {
        messageTimestamps.put(message, System.currentTimeMillis());
        addReceivedMessageToLayout(message, timestamp);
    }

    private void addReceivedMessageToLayout(String message, String timestamp) {
        Toast.makeText(this, "Received: " + message, Toast.LENGTH_SHORT).show();
    }

    private class SendMessageTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String senderId = params[0];
            String receiverId = params[1];
            String message = params[2];
            String filePath = params[3];


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            // Handle the result after sending the message
            if (success) {
                Toast.makeText(MainActivity9.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity9.this, "Failed to send message", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
