package com.example.danhpham.group2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class User extends AppCompatActivity {
    TextView email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        email = (TextView) findViewById(R.id.editText2);
        phone = (TextView) findViewById(R.id.editText3);
        Intent intent = getIntent();
        String newText;
        newText = intent.getStringExtra("email");
        email.setText(newText);
        newText = intent.getStringExtra("phone");
        phone.setText(newText);


    }

    public void goToOrders(View view){
        Intent startOrders = new Intent(this, userOrders.class);
        startActivity(startOrders);
    }

}
