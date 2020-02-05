package com.smzn.listviewretrivesqlitetextimages.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.smzn.listviewretrivesqlitetextimages.model.CityModel;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "mizdatabases.db";
    private static final int DATABASE_VERSION =3;

    Context context;


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }



    public ArrayList<CityModel> getListData(){
        try {


            ArrayList<CityModel> cityArrayList = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            if (sqLiteDatabase!=null){

                Cursor cursor = sqLiteDatabase.rawQuery("select * from city",null);

                if (cursor.getCount() != 0){

                    while (cursor.moveToNext()){
                        String cityName = cursor.getString(0);
                        byte[] cityPhoto = cursor.getBlob(1);
                        String cityPopulation = cursor.getString(2);

                        //String cityPopulotion = cursor.getString(3);

                        Bitmap bitmap = BitmapFactory.decodeByteArray(cityPhoto,0,cityPhoto.length);
                        cityArrayList.add(
                                new CityModel(
                                        cityName,cityPopulation,bitmap
                                )
                        );

                    }

                    return cityArrayList;

                }else {
                    Toast.makeText(context, "retrived data load failed..", Toast.LENGTH_SHORT).show();
                    return null;
                }



            }else {
                Toast.makeText(context, "Your Database have no data yet!", Toast.LENGTH_SHORT).show();
                return null;
            }

        }catch (Exception e){
            Log.e("Error",e.getMessage());
            return null;
        }
    }
}
