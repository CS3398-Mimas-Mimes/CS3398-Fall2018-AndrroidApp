package com.example.danhpham.group2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import android.support.v4.content.LocalBroadcastManager;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;

public class User extends AppCompatActivity {

    //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    String id;
    String url = "http://www.dmp131.tech/customer_info.php";
    TextView email, phone;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        requestQueue = Volley.newRequestQueue(this);

        // try passing string
        //LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("IDINTENT"));

        // try passing string
        /*
        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            this.id = extras.getString("id");
            Toast.makeText(getApplicationContext(), String.format("ID received: %s", this.id), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "ID not received", Toast.LENGTH_LONG).show();
        }
        */

        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        //final String id = prefs.getString("id", "1000");
        // TODO may need to turn JSONObject request to String request, unable to pass id to php with current code

        email = (TextView) findViewById(R.id.editText2);
        phone = (TextView) findViewById(R.id.editText3);

        /*
        JSONObject paramJson = new JSONObject();


        try {
            paramJson.put("id", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */


        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            Toast.makeText(getApplicationContext(), String.format("Response received: %s", response), Toast.LENGTH_LONG).show();

                            JSONObject obj = new JSONObject(response);

                            String emailAddr = obj.getString("email");
                            String phoneNum = obj.getString("phone");
                            Toast.makeText(getApplicationContext(), String.format("Email: %s", emailAddr), Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(), String.format("Phone: %s", phoneNum), Toast.LENGTH_LONG).show();


                            /* Here 'response' is a String containing the response you received from the website... */

                            email.setText(emailAddr);
                            phone.setText(phoneNum);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //String id = "26";
                params.put("id",id);
                return params;
            }
        };


        /*
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, paramJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            String emailAddr = response.getString("email");
                            String phoneNum = response.getString("phone");
                            Toast.makeText(getApplicationContext(), String.format("Email: %s", emailAddr), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), String.format("Phone: %s", phoneNum), Toast.LENGTH_SHORT).show();

                            email.setText(emailAddr);
                            phone.setText(phoneNum);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"Unable to set email and phone", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        */
        requestQueue.add(request);

    }
/*
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String receivedId = intent.getStringExtra("id");
            Toast.makeText(getApplicationContext(), String.format("Id received from login: %s", receivedId), Toast.LENGTH_LONG).show();
            id = receivedId;
        }
    };
*/
    public void goToOrders(View view){
        Intent startOrders = new Intent(this, userOrders.class);
        startActivity(startOrders);
    }

}
