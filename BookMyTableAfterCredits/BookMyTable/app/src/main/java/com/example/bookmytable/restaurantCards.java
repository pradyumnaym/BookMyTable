package com.example.bookmytable;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Firebase.Utils;

public class restaurantCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_cards);
        TextView Name = findViewById(R.id.resName);
        ImageView resImage = findViewById(R.id.resImage);
        TextView Dis = findViewById(R.id.resDis);
        TextView open = findViewById(R.id.open);
        TextView close = findViewById(R.id.close);
        TextView noTables = findViewById(R.id.tablesNo);
        TextView phno = findViewById(R.id.phno);
        Button call = findViewById(R.id.resCall);
        Button loc = findViewById(R.id.resLoc);
        Button book = findViewById(R.id.resBook);
        //final int resid=getIntent().getIntExtra("restaurantID",0);
        final String resid=getIntent().getStringExtra("restaurantID");
        Restaurant r1= new Restaurant();
        for(Restaurant r: Utils.restaurantList){
            if(r.getId().equals(resid)){
                r1=r;
                break;
            }
        }

        Name.setText(r1.getName());
        Dis.setText(r1.getDescription());
        open.setText("Opening Time :-  " +r1.getOpenTime());
        close.setText("Closing Time:-  "+r1.getCloseTime());
        phno.setText("Phone No :-  "+r1.getPhno());
        noTables.setText("Number of Tables Available:- "+r1.getTables());
        resImage.setImageResource(Integer.parseInt(r1.getImage_source()));
//         Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                Uri.parse("http://maps.google.com/maps?daddr="+Utils.restaurantList.get(resid).getLat()+","+Utils.restaurantList.get(resid).getLng()));
        final Restaurant finalR = r1;
        loc.setOnClickListener(new View.OnClickListener() {

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse("http://maps.google.com/maps?daddr="+ finalR.getLat()+","+ finalR.getLng()));
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        final Restaurant finalR1 = r1;
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ finalR1.getPhno()));
                startActivity(callIntent);
            }
        });
        final Button booknow=findViewById(R.id.resBook);
        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(restaurantCards.this,enterdetails.class);
                i.putExtra("restaurant_id",resid);
                startActivity(i);
            }
        });
//        startActivity(intent);

    }
}
