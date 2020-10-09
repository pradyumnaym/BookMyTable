package com.example.bookmytable;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CuisineListActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_list);

        dl = (DrawerLayout)findViewById(R.id.drawer);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.bringToFront();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Log.d("nav", "onNavigationItemSelected: ");
                switch(id)
                {
                    case R.id.credits:
                        startActivity(new Intent(getApplicationContext(),credits.class));
                        return true;
                       // break;
                        
                   case R.id.myBooking:
                        Toast.makeText(CuisineListActivity.this, "booked",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CuisineListActivity.this,MyBookings.class));
                       return true;
                        //break;
                    case R.id.logout:
                        deleteSharedPreferences("userdetails");
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                        //break;
                    default:
                        return true;
                }




            }
        });
    }

    public void goToRestaurants(View view) {
        Intent i= new Intent(getApplicationContext(),RestaurantListActivity.class);
        switch (view.getId()){
            case R.id.chinese:  i.putExtra("cuisine","Chinese");
                                break;
            case R.id.north:    i.putExtra("cuisine","North Indian");
                break;
            case R.id.south:    i.putExtra("cuisine","South Indian");
                break;
            case R.id.italian:   i.putExtra("cuisine","Italian");
                break;
            case R.id.mcd:  i.putExtra("cuisine","MCD");
                break;
        }
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
