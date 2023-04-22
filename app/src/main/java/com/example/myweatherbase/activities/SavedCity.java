package com.example.myweatherbase.activities;

public class SavedCity {

    private String cityName;
    private String countryName;
    private int image;


    public SavedCity(String cityName, String countryName, int image) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.image = image;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getImage() {
        return image;
    }
}
