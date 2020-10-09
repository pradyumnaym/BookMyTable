package com.example.bookmytable;

import android.content.Intent;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Classes.User;
import com.example.bookmytable.FirebaseAPI.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.getData();  //retrieves all the data from the cloud
        Log.i("msg",Utils.userList.toString());
        User newUser = new User("a","b","c","d");
        Utils.putUser(newUser);
        Restaurant newRestaurant = new Restaurant("1","ss","1.0111","1.2221","123","345",new ArrayList<String>(Arrays.asList("1","2","3","4")));
        Utils.putRestaurant(newRestaurant);
        Utils.putBooking(new Booking("1","2","3","4","5"));

    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.getData();
        /*
        * public Restaurant(String name,String lat,String lng,String openTime,String closeTime,String description,String image_source,String tables){
        this.name=name;
        this.lat=lat;
        this.lng=lng;
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.description=description;
        this.image_source=image_source;
        this.tables=tables;
    }*/
       /* Utils.putRestaurant(new Restaurant("Onesta,Banashankari","12.9271108","77.5463704","10 am","11 pm","Pizzas and pastas made with sauce made fresh every day from locally sourced, super tomatoes!",Integer.toString(R.drawable.onestabanashankari),"7",Integer.toString(R.drawable.res1)));
        Utils.putRestaurant(new Restaurant("Ayodhya Upachar","12.9279098","77.5440542","7 am","9 pm","This is an great restaurant for Darshini style of food lovers and vegetarians at cheap prices",Integer.toString(R.drawable.ayodhyaupachar),"7",Integer.toString(R.drawable.res2)));
        Utils.putRestaurant(new Restaurant("Pizza Hut Kathreguppe","12.9280791","77.5468884","11 am","11 pm","Tastiest pizzas starting at Rs. 99 have won the battle of cravings and claimed the throne!",Integer.toString(R.drawable.pizzahut),"15",Integer.toString(R.drawable.res3)));
        Utils.putRestaurant(new Restaurant("FreshMenu","12.9236882","77.5490826","9 am","11 pm","Your one stop solution to chef crafted meals delivered to your doorstep in 45 minutes.",Integer.toString(R.drawable.freshmenu),"4",Integer.toString(R.drawable.res4)));
        Utils.putRestaurant(new Restaurant("Just Shawarma","12.9250586" , "77.5502898","12 pm","11 pm","Bringing Shawarmas to Bangalore like never before !! , Shawarmas Loaded with Chicken , Fries and Malgoum Shawarmas loaded with Cheese",Integer.toString(R.drawable.s),"5",Integer.toString(R.drawable.res5)));
        Utils.putRestaurant(new Restaurant("Cafe Down the Alley" , "12.9326876" , "77.5352604","12 pm","11 pm","Great place to spend some quality time with friends. Pocket friendly and has board games as well!",Integer.toString(R.drawable.caffedown),"7",Integer.toString(R.drawable.res6)));
*/



        //User u = new User("ab","bc","cd","asd");
        //Utils.putUser(u);
        findViewById(R.id.Login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText u1=(EditText)findViewById(R.id.usernameLogin);
                EditText p1=(EditText)findViewById(R.id.passwordLogin);
                String username = u1.getText().toString();
                String password = p1.getText().toString();
                boolean flag=true;
                for(User u:Utils.userList){
                    if(u.getEmail().equals(username) && u.getPassword().equals(password)){
                        //set intent
                        flag=false;
                        startActivity(new Intent(MainActivity.this,RestaurantListActivity.class));
                        finish();
                    }
                }
                //no match
                if(flag) {
                    u1.setText("");
                    p1.setText("");
                    Toast.makeText(getApplicationContext(), "Please check the username and the passsword", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void goToSignup(View view) {
        Intent signup = new Intent(getApplicationContext(),signup.class);
        startActivity(signup);

    }

}
