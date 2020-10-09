package com.example.bookmytable;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Firebase.Utils;

import java.util.ArrayList;

public class MyBookings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);
        SharedPreferences sp = getSharedPreferences("userdetails",MODE_PRIVATE);
        String loguser=sp.getString("uid","0");
        ArrayList<String> tech = new ArrayList<String>();
        tech.add( "\t" + "RId" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Book Time" + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Date");
        for (Booking book: Utils.bookingList){
            if(book.getUid().equals(loguser)){
                String s = "\t\t\t\t\t" + book.getRid() + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + book.getT1h()+":"+book.getT1m()+ " - " + book.getT2h()+":"+book.getT2m() + "\t\t\t\t\t\t" +book.getD()+"-"+book.getM();
                tech.add(s);
            }
        }
        Log.i("msg",Utils.bookingList.toString());
        String[] fin = tech.toArray(new String[tech.size()]);
        ListView listView=findViewById(R.id.listView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.listbook, R.id.textView, fin);
        listView.setAdapter(adapter);
    }
}

