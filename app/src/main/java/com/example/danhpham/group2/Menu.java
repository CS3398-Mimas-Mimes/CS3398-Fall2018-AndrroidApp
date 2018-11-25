package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.*;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.util.Log;

public class Menu extends Activity {

    Button bmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Menu: onCreate", "Starting onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bmenu = (Button) findViewById(R.id.menuText);
        Log.i("Menu: onCreate", "Menu button initialized");

        bmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Menu: onClick", "Menu button clicked");
                getMenu();
            }
        });
    }

    public void getMenu() {
        Log.i("Menu: getMenu", "Starting to grab menu information...");
        String url = "http://dmp131.tech.com/menu_online.php";
        /*
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        //Log.d("Response", response.toString());
                        if (response.length() > 0) {
                            Toast.makeText(getApplicationContext(), String.format("Found %d menu item(s) in db", response.length()),
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Found no menu items in db",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                },null);
                */
        Log.i("Menu: getMenu", "Reached before request successfully");
        try {
            JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>()
                    {
                        @Override
                        public void onResponse(JSONArray response) {
                            // display response
                            String responseMsg = String.format("Response from server: %s\n", response.toString());
                            Log.i("Menu: getMenu", responseMsg);
                            if (response.size() > 0) {
                                Log.i("Menu: getMenu", "Response is not empty");
                                Toast.makeText(getApplicationContext(), String.format("Found %d menu item(s) in db", response.length()),
                                    Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Log.i("Menu: getMenu", "Response is empty");
                                Toast.makeText(getApplicationContext(), "Found no menu items in db",
                                    Toast.LENGTH_SHORT).show();
                            }
                        }
                    },null);
            Volley.newRequestQueue(this).add(request);
            Log.i("Menu: getMenu", "Successfully added request to queue");    
        } catch (Exception e) {
            Log.i("Menu: catch block", "Unable to process JSONArray request");
            e.printStackTrace();
        }
    }
}
