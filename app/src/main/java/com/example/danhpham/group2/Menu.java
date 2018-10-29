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

public class Menu extends Activity {

    Button bmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bmenu = (Button) findViewById(R.id.menuText);

        bmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMenu();
            }
        });
    }

    public void getMenu() {
        String url = "http://dmp131.000webhostapp.com/menu_online.php";
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
        Volley.newRequestQueue(this).add(request);
    }
}
