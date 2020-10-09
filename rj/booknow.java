package com.example.bookmytable;

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
        populatelistView();
        registerClickCallBack();
    }

    private void populatelistView() {
        final String resid = getIntent().getStringExtra("restaurant_id");
        final String starthour = getIntent().getStringExtra("starthour");
        final String startmin = getIntent().getStringExtra("startmin");
        final String endhour = getIntent().getStringExtra("endhour");
        final String endmin = getIntent().getStringExtra("endmin");
        final String year = getIntent().getStringExtra("year");
        final String month = getIntent().getStringExtra("month");
        final String date1 = getIntent().getStringExtra("date");
        int shour = Integer.parseInt(starthour);
        int ehour = Integer.parseInt(endhour);
        int smin = Integer.parseInt(startmin);
        int emin = Integer.parseInt(endmin);
        int rid = Integer.parseInt(resid);
        int date = Integer.parseInt(date1);

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

        for (Booking b : Utils.bookingList) {
            b.getDate();

        }

        ArrayList<String> itemstodisplay = new ArrayList<>();
        int no_of_tables = Integer.parseInt(r1.getTables());
        for (int i = 1; i <= no_of_tables; i++) {
            boolean flag=true;

            for (Booking b : Utils.bookingList) {
                //check if this booking is for this table

                if (b.getTableNo() != "" && rid == Integer.parseInt(b.getRid())&&date==Integer.parseInt(b.getDate())&&month==Integer.parseInt(b.getmonth())) {

                    if(Integer.parseInt(b.getT1())=<shour<=Integer.parseInt(b.getT2())||Integer.parseInt(b.getT1())=<ehour<=Integer.parseInt(b.getT2()))
                    {
                        flag=false
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
    }

    private void registerClickCallBack() {
        ListView list = (ListView) findViewById(R.id.listviewmain);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String message = "You clicked " + position + "which is" + textView.getText().toString();
                SharedPreferences s= new SharedPreferences("userdetails",MODE_PRIVATE);
                String uid= s.getString("uid","");
                Utils.putBooking(new Booking(uid,));
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });


    }
}
    //getExtra and check which tables are available and put them in the listview
    //https://www.javatpoint.com/android-listview-example
    //http://android-er.blogspot.com/2017/03/android-listview-with-checkbox.html
    // use the above link(second link more relevant, but use radio and not checkbox) for listview it's simple only



