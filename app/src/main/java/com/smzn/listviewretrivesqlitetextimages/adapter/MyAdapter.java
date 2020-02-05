package com.smzn.listviewretrivesqlitetextimages.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.smzn.listviewretrivesqlitetextimages.R;
import com.smzn.listviewretrivesqlitetextimages.model.CityModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<CityModel> cityArrayList;


    public MyAdapter(ArrayList<CityModel> cityArrayList) {
        this.cityArrayList = cityArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CityModel city = cityArrayList.get(position);
        holder.cityName.setText(city.getCityName());
        holder.cityPopulation.setText(city.getCityPopulation());
        holder.cityPhoto.setImageBitmap(city.getCityPhoto());

    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView cityName,cityPopulation;
        ImageView cityPhoto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cityName = itemView.findViewById(R.id.tv_city_name);
            cityPopulation = itemView.findViewById(R.id.tv_city_population);
            cityPhoto = itemView.findViewById(R.id.city_images);
        }
    }

}
