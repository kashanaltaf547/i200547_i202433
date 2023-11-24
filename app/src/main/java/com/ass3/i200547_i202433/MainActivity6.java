package com.ass3.i200547_i202433;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    private EditText searchEditText;
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<AdItem> adItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        searchEditText = findViewById(R.id.edit1);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adItemList = new ArrayList<>();
        adapter = new SearchAdapter(adItemList);
        recyclerView.setAdapter(adapter);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Implement as needed
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Implement search logic and update the adapter
                filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Implement as needed
            }
        });

        // Fetch initial data (you need to replace the URL with your API endpoint)
        new FetchAdsTask().execute("http://localhost/phpmyadmin/index.php?route=/database/structure&db=user_login_register");
    }

    private void filter(String text) {
        // Filter the data based on the search text and update the adapter
        List<AdItem> filteredList = new ArrayList<>();
        for (AdItem adItem : adItemList) {
            if (adItem.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(adItem);
            }
        }
    }

    private class FetchAdsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    return stringBuilder.toString();
                } finally {
                    urlConnection.disconnect();
                }
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            // Parse the JSON response and update the adItemList
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String title = jsonObject.getString("title");
                    // Add other fields as needed
                    AdItem adItem = new AdItem(title);
                    adItemList.add(adItem);
                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static class AdItem {

        private String title;

        public AdItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

        private List<AdItem> itemList;
        private List<AdItem> filteredList;

        public SearchAdapter(List<AdItem> itemList) {
            this.itemList = itemList;
            this.filteredList = new ArrayList<>(itemList);
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            AdItem adItem = filteredList.get(position);
            holder.itemTitle.setText(adItem.getTitle());
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView itemTitle;
            TextView itemDescription;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                itemTitle = itemView.findViewById(R.id.itemTitle);
                itemDescription = itemView.findViewById(R.id.itemDescription);
            }
        }
    }


}
