package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;

public class User extends AppCompatActivity {

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        //Toast.makeText(getApplicationContext(), String.format("ID IN USER CLASS: %", id), Toast.LENGTH_SHORT).show();

    }

    public void goToOrders(View view){
        Intent startOrders = new Intent(this, userOrders.class);
        //Toast.makeText(getApplicationContext(), String.format("ID in goToOrders(): %s", id), Toast.LENGTH_LONG).show();
        startOrders.putExtra("id", id);
        //Toast.makeText(getApplicationContext(), String.format("Passing ID to Order Display: %s", id), Toast.LENGTH_LONG).show();
        startActivity(startOrders);
    }

}
