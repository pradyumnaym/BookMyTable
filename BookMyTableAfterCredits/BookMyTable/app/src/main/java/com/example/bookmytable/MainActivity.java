package com.example.bookmytable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Classes.User;
import com.example.bookmytable.Firebase.Utils;

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
        final SharedPreferences sp= getSharedPreferences("userdetails",MODE_PRIVATE);
        if(sp.contains("uid")){
            startActivity(new Intent(MainActivity.this,CuisineListActivity.class));
            for(User u:Utils.userList){
                if(sp.getString("uid",null).equals(u.getEmail())){
                    Toast.makeText(getApplicationContext(),"Welcome Back "+u.getName(),Toast.LENGTH_LONG).show();
                    break;
                }

            }

            finish();
        }
//        Utils.putRestaurant(new Restaurant("Onesta,Banashankari","12.9271108","77.5463704","10 am","11 pm","Pizzas and pastas made with sauce made fresh every day from locally sourced, super tomatoes!",Integer.toString(R.drawable.onestabanashankari),"7",Integer.toString(R.drawable.res1),"Italian","080 48655715","1"));
//        Utils.putRestaurant(new Restaurant("Ayodhya Upachar","12.9279098","77.5440542","7 am","9 pm","This is an great restaurant for Darshini style of food lovers and vegetarians at cheap prices",Integer.toString(R.drawable.ayodhyaupachar),"7",Integer.toString(R.drawable.res2),"North Indian","00 09901269901","2"));
//        Utils.putRestaurant(new Restaurant("Pizza Hut Kathreguppe","12.9280791","77.5468884","11 am","11 pm","Tastiest pizzas starting at Rs. 99 have won the battle of cravings and claimed the throne!",Integer.toString(R.drawable.pizzahut),"15",Integer.toString(R.drawable.res3),"Italian","+918030246398","3"));
//        Utils.putRestaurant(new Restaurant("FreshMenu","12.9236882","77.5490826","9 am","11 pm","Your one stop solution to chef crafted meals delivered to your doorstep in 45 minutes.",Integer.toString(R.drawable.freshmenu),"4",Integer.toString(R.drawable.res4),"Italian","097401 17603","4"));
//        Utils.putRestaurant(new Restaurant("Just Shawarma","12.9250586" , "77.5502898","12 pm","11 pm","Bringing Shawarmas to Bangalore like never before !! , Shawarmas Loaded with Chicken , Fries and Malgoum Shawarmas loaded with Cheese",Integer.toString(R.drawable.shawarma),"5",Integer.toString(R.drawable.res5),"Italian","+91 9620221026","5"));
//        Utils.putRestaurant(new Restaurant("Cafe Down the Alley" , "12.9326876" , "77.5352604","12 pm","11 pm","Great place to spend some quality time with friends. Pocket friendly and has board games as well!",Integer.toString(R.drawable.caffedown),"7",Integer.toString(R.drawable.res6),"Cafe","080 26724489","6"));
//        Utils.putRestaurant(new Restaurant("Adigas","12.9114462","77.5622642","10 am","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.adigas),"16",Integer.toString(R.drawable.res3),"North Indian","+91 8494904666","7"));
//        Utils.putRestaurant(new Restaurant("Ayodhya Upachar","12.9279098","77.5440542","7 am","9 pm","This is an great restaurant for Darshini style of food lovers and vegetarians at cheap prices",Integer.toString(R.drawable.ayodhyaupachar),"7",Integer.toString(R.drawable.res2),"South Indian","00 09901269901","8"));
//        Utils.putRestaurant(new Restaurant("Adigas","12.9114462","77.5622642","11 am","11 pm","Tastiest Tastiest and Healthiest meals 24/7 starting at Rs. 99 have won the battle of cravings and claimed the throne!",Integer.toString(R.drawable.adigas),"16",Integer.toString(R.drawable.res2),"South Indian","+91 8494904666","9"));
//        Utils.putRestaurant(new Restaurant("FreshMenu","12.9236882","77.5490826","9 am","11 pm","Your one stop solution to chef crafted meals delivered to your doorstep in 45 minutes.",Integer.toString(R.drawable.freshmenu),"4",Integer.toString(R.drawable.res4),"Chinese","097401 17603","10"));
//        Utils.putRestaurant(new Restaurant("Just Shawarma","12.9250586" , "77.5502898","12 pm","11 pm","Bringing Shawarmas to Bangalore like never before !! , Shawarmas Loaded with Chicken , Fries and Malgoum Shawarmas loaded with Cheese",Integer.toString(R.drawable.shawarma),"5",Integer.toString(R.drawable.res5),"Chinese","+91 9620221026","11"));
//        Utils.putRestaurant(new Restaurant("Adigas" , "12.9114462" , "77.5622642","12 pm","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.adigas),"16",Integer.toString(R.drawable.res2),"Chinese","+91 8494904666","12"));
//
//
//        Utils.putRestaurant(new Restaurant("Kadamba","12.9114462","77.5622642","10 am","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.kadamba),"16",Integer.toString(R.drawable.res3),"North Indian","+91 8494904666","13"));
//        Utils.putRestaurant(new Restaurant("Mane Thindi","12.9279098","77.5440542","7 am","9 pm","This is an great restaurant for Darshini style of food lovers and vegetarians at cheap prices",Integer.toString(R.drawable.mane),"7",Integer.toString(R.drawable.res2),"South Indian","00 09901269901","14"));
//        Utils.putRestaurant(new Restaurant("Kadamba","12.9114462","77.5622642","11 am","11 pm","Tastiest Tastiest and Healthiest meals 24/7 starting at Rs. 99 have won the battle of cravings and claimed the throne!",Integer.toString(R.drawable.kadamba),"16",Integer.toString(R.drawable.res2),"South Indian","+91 8494904666","15"));
//        Utils.putRestaurant(new Restaurant("Shanti Sagar","12.9236882","77.5490826","9 am","11 pm","Your one stop solution to chef crafted meals delivered to your doorstep in 45 minutes.",Integer.toString(R.drawable.shanti),"4",Integer.toString(R.drawable.res4),"Chinese","097401 17603","16"));
//        Utils.putRestaurant(new Restaurant("Swati","12.9250586" , "77.5502898","12 pm","11 pm","Favourite place for all the vegetarians out there",Integer.toString(R.drawable.swati),"5",Integer.toString(R.drawable.res5),"Chinese","+91 9620221026","17"));
//        Utils.putRestaurant(new Restaurant("Kadamba" , "12.9114462" , "77.5622642","12 pm","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.kadamba),"16",Integer.toString(R.drawable.res2),"Chinese","+91 8494904666","18"));
//
//        Utils.putRestaurant(new Restaurant("Nandhana","12.9114462","77.5622642","10 am","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.nandhana),"16",Integer.toString(R.drawable.res3),"North Indian","+91 8494904666","19"));
//        Utils.putRestaurant(new Restaurant("Mane Thindi","12.9279098","77.5440542","7 am","9 pm","This is an great restaurant for Darshini style of food lovers and vegetarians at cheap prices",Integer.toString(R.drawable.mane),"7",Integer.toString(R.drawable.res2),"North Indian","00 09901269901","20"));
//        Utils.putRestaurant(new Restaurant("Nandhana","12.9114462","77.5622642","11 am","11 pm","Tastiest Tastiest and Healthiest meals 24/7 starting at Rs. 99 have won the battle of cravings and claimed the throne!",Integer.toString(R.drawable.nandhana),"16",Integer.toString(R.drawable.res2),"South Indian","+91 8494904666","21"));
//        Utils.putRestaurant(new Restaurant("Shanti Sagar","12.9236882","77.5490826","9 am","11 pm","Your one stop solution to chef crafted meals delivered to your doorstep in 45 minutes.",Integer.toString(R.drawable.shanti),"4",Integer.toString(R.drawable.res4),"North Indian","097401 17603","22"));
//        Utils.putRestaurant(new Restaurant("Swati","12.9250586" , "77.5502898","12 pm","11 pm","Favourite place for all the vegetarians out there",Integer.toString(R.drawable.swati),"5",Integer.toString(R.drawable.res5),"North Indian","+91 9620221026","23"));
//        Utils.putRestaurant(new Restaurant("Nandhana" , "12.9114462" , "77.5622642","12 pm","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.nandhana),"16",Integer.toString(R.drawable.res2),"Chinese","+91 8494904666","24"));
//
//        Utils.putRestaurant(new Restaurant("Udupi","12.9114462","77.5622642","10 am","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.udupi),"16",Integer.toString(R.drawable.res3),"North Indian","+91 8494904666","25"));
//        Utils.putRestaurant(new Restaurant("Mcdonald's","12.9279098","77.5440542","7 am","9 pm","Best western meals 24/7",Integer.toString(R.drawable.mcdres),"7",Integer.toString(R.drawable.res2),"MCD","00 09901269901","26"));
//        Utils.putRestaurant(new Restaurant("Udupi","12.9114462","77.5622642","11 am","11 pm","Tastiest Tastiest and Healthiest meals 24/7 starting at Rs. 99 have won the battle of cravings and claimed the throne!",Integer.toString(R.drawable.udupi),"16",Integer.toString(R.drawable.res2),"South Indian","+91 8494904666","27"));
//        Utils.putRestaurant(new Restaurant("Shanti Sagar","12.9236882","77.5490826","9 am","11 pm","Your one stop solution to chef crafted meals delivered to your doorstep in 45 minutes.",Integer.toString(R.drawable.shanti),"4",Integer.toString(R.drawable.res4),"South Indian","097401 17603","28"));
//        Utils.putRestaurant(new Restaurant("Swati","12.9250586" , "77.5502898","12 pm","11 pm","Favourite place for all the vegetarians out there",Integer.toString(R.drawable.swati),"5",Integer.toString(R.drawable.res5),"South Indian","+91 9620221026","29"));
//        Utils.putRestaurant(new Restaurant("Udupi" , "12.9114462" , "77.5622642","12 pm","11 pm","Tastiest and Healthiest meals 24/7",Integer.toString(R.drawable.udupi),"16",Integer.toString(R.drawable.res2),"Chinese","+91 8494904666","30"));


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
                        SharedPreferences.Editor e=sp.edit();
                        e.putString("uid",username);
                        startActivity(new Intent(MainActivity.this,CuisineListActivity.class));
                        e.commit();
                        Toast.makeText(getApplicationContext(),"Welcome "+u.getName(),Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
                //no match
                if(flag) {
                    u1.setText("");
                    p1.setText("");
                    Toast.makeText(getApplicationContext(), "Please check the username and the password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void goToSignup(View view) {
        Intent signup = new Intent(getApplicationContext(),signup.class);
        startActivity(signup);

    }

}
