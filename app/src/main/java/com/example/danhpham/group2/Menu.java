package com.example.danhpham.group2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button bSubmit;

    String JsonURL = "http://dmp131.tech/menu_online.php";
    String data = "Current Menu:\n\n\n";
    RequestQueue requestQueue;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                JsonURL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try{
                            // Loop through the array elements
                            Toast.makeText(getApplicationContext(), String.format("Length of request: %d", response.length()), Toast.LENGTH_LONG).show();
                            JSONObject menuItem;
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                menuItem = response.getJSONObject(i);

                                // Get the current student (json object) data
                                String mealNum = menuItem.getString("foodId");
                                Toast.makeText(getApplicationContext(), String.format("FoodId: %s", mealNum), Toast.LENGTH_SHORT).show();
                                String food = menuItem.getString("foodName");
                                Toast.makeText(getApplicationContext(), String.format("Food: %s", food), Toast.LENGTH_SHORT).show();
                                String price = menuItem.getString("price");

                                // Display the formatted json data in text view
                                //data += String.format("Meal Number %s\n%s - $%s\n\n", mealNum, food, price);
                                data += "Meal Number " + mealNum + "\n" + food + " - $" + price + "\n\n";
                                //Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
                            }
                            results = (TextView) findViewById(R.id.jsonData);
                            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
                            results.setText(data);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred

                    }
                }
        );

        //Log.i("Menu", "Created Successfully.");
        Toast.makeText(getApplicationContext(), String.format("Request: %s", request.toString()), Toast.LENGTH_LONG).show();
        this.requestQueue = Volley.newRequestQueue(this);
        //this.results = (TextView) findViewById(R.id.jsonData);
        //Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
        //this.results.setText(data);
        this.requestQueue.add(request);

        bSubmit = findViewById(R.id.btn_confirm);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setbConfirmPage();
            }
        });

    }

    public void setbConfirmPage(){
        CheckBox burger = findViewById(R.id.Hamburger);
        CheckBox chickenStrips = findViewById(R.id.chickenStrips);
        CheckBox loadedFries = findViewById(R.id.loadedFries);
        CheckBox vanillaShake = findViewById(R.id.vanillaShake);
        //Intent i=new Intent(this, cart.class);
        int size = 0;
        String[] Orders = new String[4];
        //ArrayList<String> orders = new ArrayList<>();
        if(burger.isChecked()) {
            //orders.add("Hamburger");
            Orders[0] = "Hamburger";
            size++;
        }
        if(chickenStrips.isChecked()) {
            //orders.add("Chicken Strips");
            Orders[1] = "Chicken Strips";
            size++;
        }
        if(loadedFries.isChecked()) {
            //orders.add("Loaded Fries");
            Orders[2] = "Loaded Fries";
            size++;
        }
        if(vanillaShake.isChecked()) {
            //orders.add("Vanilla Shake");
            Orders[3] = "Vanilla Shake";
        }
        Intent i = new Intent(getApplicationContext(),cart.class);
        //Bundle bundle = new Bundle();
        System.out.println(Orders); //for reference

        for(int inc = 0; inc < Orders.length; inc++){
            if (Orders[inc] != null){
                i.putExtra("order", Orders[inc]);
            }
        }
        startActivity(i);
        System.out.println(Orders); //for reference
        Intent startCart = new Intent(this, cart.class);
        startActivity(startCart);
    }
}
