package com.example.bookmytable;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookmytable.Classes.Restaurant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class restaurantListAdapter extends RecyclerView.Adapter<restaurantListAdapter.ViewHolder> {

    private ArrayList<Restaurant> restaurantList = new ArrayList<>();
    private LayoutInflater mInflater;
    private Intent intent;
    private Context context;
    private double lat=12.93377335,lng=77.53468188;

    public restaurantListAdapter(Context context, ArrayList<Restaurant> r,Intent intent,String cuisine){
        mInflater=LayoutInflater.from(context);
        //restaurantList.addAll(r);
        for(Restaurant res:r){
            if(res.getCuisine().equals(cuisine)) restaurantList.add(res);
        }
        this.intent=intent;
        this.context=context;
        }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.restaurantrow,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setView(position);
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public void setLocation(double a,double b) {
        lat=a;
        lng=b;
        notifyDataSetChanged();
    }

    public void sortByName() {
        Collections.sort(restaurantList,compareByName);
        notifyDataSetChanged();
    }

    public void sortByDist() {
        Collections.sort(restaurantList,compareByDist);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{

        TextView tv,title;
        ImageView iv;

        ViewHolder(View v){
            super(v);
            tv=v.findViewById(R.id.shortDescriptionTextView);
            iv=v.findViewById(R.id.imageView);
            title=v.findViewById(R.id.title);
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            //pass an intent here
            Log.i("msg",Integer.toString(position));
            intent.putExtra("restaurantID",restaurantList.get(position).getId());
            context.startActivity(intent);

        }

        public void setView(int position) {
            Restaurant r=restaurantList.get(position);
            String text= r.getDescription();
            String timings="Timings: "+r.getOpenTime()+" To "+r.getCloseTime();
            tv.setText(text+"\n"+timings+"\nDistance: "+(float)Math.round(distanceInKm(r) * 100) / 100+"Km");
            title.setText(r.getName());
            iv.setImageResource(Integer.parseInt(r.getImage_source()));
        }
    }
    float distanceInKm(Restaurant r){
        Location loc1 = new Location("");
        loc1.setLatitude(lat);
        loc1.setLongitude(lng);

        Location loc2 = new Location("");
        loc2.setLatitude(Double.parseDouble(r.getLat()));
        loc2.setLongitude(Double.parseDouble(r.getLng()));

        float distanceInMeters = loc1.distanceTo(loc2);
        return distanceInMeters/1000;
    }
    Comparator<Restaurant> compareByDist = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            double d1=distanceInKm(o1);
            double d2=distanceInKm(o2);
            if(d1>d2)
                return 1;
            else
                return -1;

        }
    };
    Comparator<Restaurant> compareByName= new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant, Restaurant t1) {
            return restaurant.getName().compareTo(t1.getName());
        }
    };

}
