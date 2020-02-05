package com.smzn.listviewretrivesqlite.model;

import android.graphics.Bitmap;

public class CityModel {

    String CityName;
    Bitmap CityPhoto;

    public CityModel(String cityName, Bitmap cityPhoto) {
        CityName = cityName;
        CityPhoto = cityPhoto;
    }


    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public Bitmap getCityPhoto() {
        return CityPhoto;
    }

    public void setCityPhoto(Bitmap cityPhoto) {
        CityPhoto = cityPhoto;
    }
}

