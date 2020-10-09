package com.example.bookmytable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Firebase.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class enterdetails extends AppCompatActivity {
    Restaurant r2 = new Restaurant();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdetails);
        final String resid=getIntent().getStringExtra("restaurant_id");
        for(Restaurant r: Utils.restaurantList){
            if(r.getId().equals(resid)){
                r2=r;
                break;
            }
        }
        final String str= r2.getName();
        //String str= "Restaurant Name"; // get this from database by getting the restaurant id intent of the previous activity using getIntExtra()
        TextView tv = (TextView)findViewById(R.id.resname);
        tv.setText(str);
        sendData();
    }
    public void sendData() {
        final String resid=getIntent().getStringExtra("restaurant_id");
        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker starttimepicker=findViewById((R.id.starttimePicker));
        TimePicker endtimepicker=findViewById(R.id.endtimePicker);
//        Date totime = formatter.parse(tot);
        int year = datePicker.getYear();
        int month= datePicker.getMonth();
        int date = datePicker.getDayOfMonth();
        int starthour=starttimepicker.getHour();
        int startmin=starttimepicker.getMinute();
        int endhour=endtimepicker.getHour();
        int endmin=endtimepicker.getMinute();

        if(starthour<=Integer.parseInt(r2.getOpenTime())&&endhour>=Integer.parseInt(r2.getCloseTime()))
        {
            Toast.makeText(this,"Choose different time",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent=new Intent(getApplicationContext(),booknow.class);
            intent.putExtra("restaurant_id",resid);
            intent.putExtra("starthour",starthour);
            intent.putExtra("startmin",startmin);
            intent.putExtra("endhour",endhour);
            intent.putExtra("endmin",endmin);
            intent.putExtra("year",year);
            intent.putExtra("month",month);
            intent.putExtra("date",date);
            startActivity(intent);

        }
        //check if time is in b/w start time and end time (get start time and end time from DB)
        //Just putExtra these values ,  startActivity(intent)
    }
}

