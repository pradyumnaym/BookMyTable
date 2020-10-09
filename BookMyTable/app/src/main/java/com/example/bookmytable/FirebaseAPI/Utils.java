package com.example.bookmytable.FirebaseAPI;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Classes.User;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    static Firebase fb=new Firebase("https://bookmytable-f636c.firebaseio.com/");
    static DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
    public static ArrayList<User> userList=new ArrayList<>();
    public static ArrayList<Restaurant> restaurantList=new ArrayList<>();
    public static ArrayList<Booking> bookingList=new ArrayList<>();
    public static void getData(){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                restaurantList.clear();
                bookingList.clear();
                DataSnapshot users=dataSnapshot.child("users");
                Iterable<com.google.firebase.database.DataSnapshot> children=users.getChildren();
                for(DataSnapshot u:children){
                    userList.add(u.getValue(User.class));
                }
                DataSnapshot restaurants=dataSnapshot.child("restaurants");
                children=restaurants.getChildren();
                for(DataSnapshot u:children){
                    restaurantList.add(u.getValue(Restaurant.class));
                }
                DataSnapshot bookings=dataSnapshot.child("bookings");
                children=bookings.getChildren();
                for(DataSnapshot u:children){
                    bookingList.add(u.getValue(Booking.class));
                }
                Log.i("msg",userList.toString());
                Log.i("msg",restaurantList.toString());
                Log.i("msg",bookingList.toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public static long getCurrentTimeInMillis(){
        return Calendar.getInstance().getTimeInMillis();
    }
    public static void putBooking(Booking b){
        DatabaseReference newChild= ref.child("bookings");
        newChild.child(Long.toString(getCurrentTimeInMillis())).setValue(b);
    }
    public static void putRestaurant(Restaurant r){
        DatabaseReference newChild= ref.child("restaurants");
        newChild.child(Long.toString(getCurrentTimeInMillis())).setValue(r);
    }
    public static void putUser(User r){
        DatabaseReference newChild = ref.child("users");
        newChild.child(Long.toString(getCurrentTimeInMillis())).setValue(r);
    }

}
