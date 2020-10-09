package com.example.bookmytable;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bookmytable.FirebaseAPI.Utils;

public class restaurantCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_cards);
        TextView tv = findViewById(R.id.resid);
        int resid=getIntent().getIntExtra("restaurantID",-1);
        tv.setText(Integer.toString(resid));
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+Utils.restaurantList.get(resid).getLat()+","+Utils.restaurantList.get(resid).getLng()));
        startActivity(intent);

    }
}
