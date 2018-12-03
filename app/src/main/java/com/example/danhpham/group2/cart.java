package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

public class cart extends AppCompatActivity {

    TextView order, creditCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        order = (TextView) findViewById(R.id.editText1);

        String newOrder;
        Intent intent = getIntent();
        newOrder = intent.getStringExtra("order");
        order.setText(newOrder);


        creditCard = (EditText) findViewById(R.id.input_creditCard);
        int id;
        HomePageActivity.getId


    }

    public void setbLogin(){
        StringRequest request = new StringRequest(Request.Method.POST, "http://dmp131.tech/login_online.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (response.contains("1")){
                            startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Order not recorded!",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
    }
}
