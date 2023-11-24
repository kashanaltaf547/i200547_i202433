package com.ass3.i200547_i202433;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMultimediaMessage("senderId", "receiverId", "This is a photo message", new File("path_to_photo"));
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle file button click
                // You may want to add code to select and send a file
                sendMultimediaMessage("senderId", "receiverId", "This is a file message", new File("path_to_file"));
            }
        });
    }

    private void sendMultimediaMessage(final String senderId, final String receiverId, final String message, final File file) {
        // AsyncTask to send multimedia message in the background
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                String apiUrl = "http://localhost/sendMessage.php";
                try {

                    URL url = new URL(apiUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();


                    // Read the response from the server
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    JSONObject jsonResponse = new JSONObject(response.toString());

                    reader.close();
                    connection.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                Toast.makeText(MainActivity9.this, "Multimedia message sent", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
}
