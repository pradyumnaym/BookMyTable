package com.example.bookmytable;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bookmytable.Firebase.Utils;

public class RestaurantListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        String cuisine=getIntent().getStringExtra("cuisine");
        RecyclerView rv = findViewById(R.id.resList);
        final restaurantListAdapter adapter = new restaurantListAdapter(RestaurantListActivity.this, Utils.restaurantList, new Intent(RestaurantListActivity.this, restaurantCards.class),cuisine);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(RestaurantListActivity.this));
        Button srtByName= findViewById(R.id.srtbyname);
        Button srtByDist= findViewById(R.id.srtByDist);
        srtByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortByName();
            }
        });
        srtByDist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.sortByDist();
            }
        });
        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProviderEnabled(String provider) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                adapter.setLocation(latitude, longitude);
                locationManager.removeUpdates(this);
                Log.v("msg",latitude+","+longitude);
                Toast.makeText(getApplicationContext(),latitude+","+longitude,Toast.LENGTH_LONG).show();
            }
        };
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        } catch (SecurityException e) {
            Log.e("msg", e.toString());

        }

    }
    }
