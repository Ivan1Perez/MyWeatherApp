package com.example.myweatherbase.activities;

public class SavedCity {

    private String cityName;
    private String countryName;

    public SavedCity(String cityName, String countryName) {
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }
}
