package com.example.bookmytable;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bookmytable.Classes.Booking;
import com.example.bookmytable.Classes.Restaurant;
import com.example.bookmytable.Firebase.Utils;

public class ThankYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        final String resid = getIntent().getStringExtra("restid");

        Restaurant r1 = new Restaurant();
        Booking b1 = new Booking();
        for (Restaurant r : Utils.restaurantList) {
            if (r.getId().equals(resid)) {
                r1=r;
                break;
            }
        }
        Notification.Builder builder= new Notification.Builder(this);
        builder.setContentText("Thank you for using this app");
        builder.setContentTitle("Thanks!!");
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?daddr="+ r1.getLat()+","+ r1.getLng()));
        PendingIntent i1 = PendingIntent.getActivities(this,0,new Intent[]{intent},PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setSmallIcon(R.mipmap.icon);
        builder.setContentIntent(i1);
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(1,builder.build());


    }
}
