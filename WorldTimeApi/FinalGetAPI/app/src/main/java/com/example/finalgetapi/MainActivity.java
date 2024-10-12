package com.example.finalgetapi;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalgetapi.model.ResponseModel;
import com.example.finalgetapi.sqdatabase.TimezoneDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "https://worldtimeapi.org/api/timezone/Asia/Dhaka";
    private TimezoneDao timezoneDao;
    private ResponseModelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timezoneDao = new TimezoneDao(this);

        ListView listView = findViewById(R.id.listView);

        // Create and send network request
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                            Gson gson = new Gson();
                            ResponseModel responseModel = gson.fromJson(jsonObject, ResponseModel.class);

                            // Insert data into SQLite
                            timezoneDao.insert(responseModel);
                            // Fetch data from SQLite and display in the ListView
                            List<ResponseModel> storedResponseModels = timezoneDao.getLatest();
                            adapter = new ResponseModelAdapter(MainActivity.this, storedResponseModels);
                            listView.setAdapter(adapter);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        // Add the request to the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timezoneDao != null) {
            timezoneDao.close();
        }
    }
}
