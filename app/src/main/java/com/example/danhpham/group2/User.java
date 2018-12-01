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

public class User extends AppCompatActivity {

    EditText email, mobileNumber, creditCard;
    Button favorites;
    Button editProfile;
    Button saveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Connecting edit text variable to framework
        email = (EditText) findViewById(R.id.user_email);
        mobileNumber = (EditText) findViewById(R.id.user_mobile_number);
        creditCard = (EditText) findViewById(R.id.user_credit_card);
        favorites = (Button) findViewById(R.id.user_favorites_button);
        editProfile = (Button) findViewById(R.id.edit_user_profile);
        saveProfile = (Button) findViewById(R.id.save_user__button);

        // Connecting button variable to frame work
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfile();
                sendEmail(email.getText().toString());
            }
        });

    }

    public void goToOrders(View view){
        Intent startOrders = new Intent(this, userOrders.class);
        startActivity(startOrders);
    }

    public void goToEditProfile(View view) {
        Intent startEditProfile = new Intent(this, EditProfile.class);
        startActivity(startEditProfile);
    }

    public void editProfile(){

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
