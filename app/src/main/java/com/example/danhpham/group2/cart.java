package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.*;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class cart extends AppCompatActivity {

    TextView order, subPrice, totalPrice;
    EditText creditCard;
    private static String id;
    private static double price, total;
    private static String creditNumber, newOrder;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        order = (TextView) findViewById(R.id.textView8);
        subPrice = (TextView) findViewById(R.id.textView15);
        totalPrice = (TextView) findViewById(R.id.textView18);
        submit = (Button) findViewById(R.id.button2);
        //String newOrder;
        //double price;
        Intent intent = getIntent();
        newOrder = intent.getStringExtra("orderItem");
        //price = intent.get("orderPrice");
        price = intent.getDoubleExtra("orderPrice", 0);
        order.setText(newOrder);

        subPrice.setText(Double.toString(price));

        total = price * 1.085;
        totalPrice.setText(Double.toString(total));


        creditCard = (EditText) findViewById(R.id.editText);

        id = HomePageActivity.getId();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrder();
            }
        });

    }


    public void setOrder(){
        String url = "http://dmp131.tech/order_infor.php";
        //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.101/loginapp/login.php",
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (response.contains("1")){
                            // Response returns "1 {id}"
                            Intent startMain = new Intent(getApplicationContext(), HomePageActivity.class);
                            startActivity(startMain);
                            //startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Cannot connect to server",
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
                params.put("id",id);
                params.put("credit",creditCard.getText().toString());
                params.put("item",newOrder);
                params.put("price",Double.toString(total));
                //params.put("password",etPassword.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);


    }

    /*

    public void setOrder(){
        //Toast.makeText(getApplicationContext(), "Test the message", Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
        String url = "http://dmp131.tech/login_online.php";
        //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.101/loginapp/login.php",
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(), "this is reponses" + response, Toast.LENGTH_SHORT).show();
                        if (response.contains("1")){
                            Toast.makeText(getApplicationContext(), "Test the message", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomePageActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(), "Wrong Information",
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
                params.put("id",id);
                params.put("credit",creditNumber);
                params.put("item",newOrder);
                params.put("price",Double.toString(total));
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);

    }
    */
}
