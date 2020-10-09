package com.example.bookmytable;

import android.content.Context;
import android.content.Intent;
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
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class restaurantListAdapter extends RecyclerView.Adapter<restaurantListAdapter.ViewHolder> {

    private ArrayList<Restaurant> restaurantList = new ArrayList<>();
    private LayoutInflater mInflater;
    private Intent intent;
    private Context context;

    public restaurantListAdapter(Context context, ArrayList<Restaurant> r,Intent intent){
        mInflater=LayoutInflater.from(context);
        restaurantList.addAll(r);
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
            intent.putExtra("restaurantID",position);
            context.startActivity(intent);

        }

        public void setView(int position) {
            Restaurant r=restaurantList.get(position);
            String text= r.getDescription();
            String timings="Timings: "+r.getOpenTime()+" To "+r.getCloseTime();
            tv.setText(text+"\n"+timings);
            title.setText(r.getName());
            iv.setImageResource(Integer.parseInt(r.getImage_source()));
        }
    }

}
