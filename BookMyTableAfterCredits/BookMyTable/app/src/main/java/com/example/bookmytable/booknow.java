package com.example.bookmytable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Firebase.Utils;
import com.example.bookmytable.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class booknow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booknow);
        final String resid = getIntent().getStringExtra("restaurant_id");
        Restaurant r2 = new Restaurant();
        for (Restaurant r : Utils.restaurantList) {
            if (r.getId().equals(resid)) {
                r2 = r;
                break;
            }
        }
        final String str = r2.getName(); // get this from database by getting the restaurant id intent of the previous activity using getIntExtra()
        TextView tv = (TextView) findViewById(R.id.resname);
        tv.setText(str);
        ImageView im = findViewById(R.id.resMap);
        im.setImageResource(Integer.parseInt(r2.getTableImage()));// instead of this put the Layout image based on id from DB
        final String starthour = getIntent().getStringExtra("starthour");
        final String startmin = getIntent().getStringExtra("startmin");
        final String endhour = getIntent().getStringExtra("endhour");
        final String endmin = getIntent().getStringExtra("endmin");
        final String year = getIntent().getStringExtra("year");
        final String month1 = getIntent().getStringExtra("month");
        final String date1 = getIntent().getStringExtra("date");
        final int shour = Integer.parseInt(starthour);
        final int ehour = Integer.parseInt(endhour);
        final int smin = Integer.parseInt(startmin);
        final int emin = Integer.parseInt(endmin);
        final int rid = Integer.parseInt(resid);
        final int date = Integer.parseInt(date1);
        final int month = Integer.parseInt(month1);

        //need to do this string items to display[
        // ]=
        //itemstodisplay   to be implemented
        Restaurant r1 = new Restaurant();
        Booking b1 = new Booking();
        for (Restaurant r : Utils.restaurantList) {
            if (r.getId().equals(resid)) {
                r1=r;
                break;
            }
        }
        //r1.getId();
//
//        for (Booking b : Utils.bookingList) {
//            b.getDate();
//
//        }

        ArrayList<String> itemstodisplay = new ArrayList<>();
        int no_of_tables = Integer.parseInt(r1.getTables());
        for (int i = 1; i <= no_of_tables; i++) {
            boolean flag=true;

            for (Booking b : Utils.bookingList) {
                //check if this booking is for this table

                if (b.getTableNo() != "" && (rid == Integer.parseInt(b.getRid())) && (date==Integer.parseInt(b.getD())) && (month==Integer.parseInt(b.getM()))) {

                    if((Integer.parseInt(b.getT1h())>=shour && Integer.parseInt(b.getT1h())<=ehour) ||(Integer.parseInt(b.getT2h())>=shour && Integer.parseInt(b.getT2h())<=ehour))
                    {
                        if((Integer.parseInt(b.getT1m())>=smin && Integer.parseInt(b.getT1m())<=emin) ||(Integer.parseInt(b.getT2m())>=emin && Integer.parseInt(b.getT2m())<=emin))
                            flag=false;
                    }
                }

            }
            if(flag==true)
            {
                itemstodisplay.add("table"+i);
            }
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.mylist, itemstodisplay);
        ListView listView = (ListView) findViewById(R.id.listviewmain);
        listView.setAdapter(adapter);

        ListView list = (ListView) findViewById(R.id.listviewmain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "You clicked " + position + "which is" + textView.getText().toString();
                SharedPreferences s= getSharedPreferences("userdetails",MODE_PRIVATE);
                String uid= s.getString("uid","");
                Utils.putBooking(new Booking(uid,Integer.toString(rid),Integer.toString(shour),Integer.toString(smin),Integer.toString(ehour),Integer.toString(emin),year,Integer.toString(month),Integer.toString(date),textView.getText().toString()));
                // String uid, String rid, String t1h,String t1m,String t2h,String t2m,String y,String m,String d,String tableN
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                Intent i =new Intent(booknow.this,ThankYouActivity.class);
                i.putExtra("restid",resid);
                startActivity(i);
                finish();
            }
        });


    }



}
//getExtra and check which tables are available and put them in the listview
//https://www.javatpoint.com/android-listview-example
//http://android-er.blogspot.com/2017/03/android-listview-with-checkbox.html
// use the above link(second link more relevant, but use radio and not checkbox) for listview it's simple only



