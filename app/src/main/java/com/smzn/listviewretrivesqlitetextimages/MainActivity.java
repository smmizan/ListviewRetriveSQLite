package com.smzn.listviewretrivesqlitetextimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.smzn.listviewretrivesqlitetextimages.adapter.MyAdapter;
import com.smzn.listviewretrivesqlitetextimages.database.MyDatabaseHelper;
import com.smzn.listviewretrivesqlitetextimages.model.CityModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper;
    ArrayList<CityModel> cityArrayList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myDatabaseHelper = new MyDatabaseHelper(this);
        cityArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);



        try {
            cityArrayList = myDatabaseHelper.getListData();
            MyAdapter myAdapter = new MyAdapter(cityArrayList);

            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(myAdapter);



        }catch (Exception e){
            Log.e("error",e.getMessage());
        }
    }
}
