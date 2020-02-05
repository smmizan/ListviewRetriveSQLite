package com.smzn.listviewretrivesqlitetextimages.model;

import android.graphics.Bitmap;

public class CityModel {

    String CityName;
    Bitmap CityPhoto;
    String CityPopulation;

    public CityModel(String cityName,String cityPopulation, Bitmap cityPhoto) {
        CityName = cityName;
        CityPopulation = cityPopulation;
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

    public String getCityPopulation() {
        return CityPopulation;
    }

    public void setCityPopulation(String cityPopulation) {
        CityPopulation = cityPopulation;
    }
}

