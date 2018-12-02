package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UserEdit extends AppCompatActivity {

    EditText email, mobileNumber, creditCard;
    Button saveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);

        // Connecting edit text variable to framework
        email = (EditText) findViewById(R.id.user_email);
        mobileNumber = (EditText) findViewById(R.id.user_mobile_number);
        creditCard = (EditText) findViewById(R.id.user_credit_card);
        saveProfile = (Button) findViewById(R.id.save_profile_button);

        // Connecting button variable to frame work
        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
                sendEmail(email.getText().toString());
            }
        });

    }

    public void saveProfile(){
        //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.101/loginapp/login.php",
        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/register_online_danh.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (response.contains("1")){
                            startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Not successful!!!!!!",
                                    Toast.LENGTH_SHORT).show();
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
                params.put("email",email.getText().toString());
                params.put("mobileNumber",mobileNumber.getText().toString());
                params.put("creditCard",creditCard.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);

    }

    protected void sendEmail(final String email) {
        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/email_online.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (!response.contains("1")){
                            Toast.makeText(getApplicationContext(), "Unable to send confirmation to email",
                                    Toast.LENGTH_SHORT).show();
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
                params.put("email",email);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }

}

