package com.example.bookmytable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bookmytable.FirebaseAPI.Utils;

public class RestaurantListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        RecyclerView rv= findViewById(R.id.resList);
        restaurantListAdapter adapter = new restaurantListAdapter(RestaurantListActivity.this, Utils.restaurantList,new Intent(RestaurantListActivity.this,restaurantCards.class));
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(RestaurantListActivity.this));
    }


}
