package com.example.myweatherbase.activities;

public class SavedCity {

    private String cityName;
    private String countryName;
    private int image;
    private String locationPath;

    public SavedCity(String cityName, String countryName, int image, String locationPath) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.image = image;
        this.locationPath = locationPath;
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

    public String getLocationPath() {
        return locationPath;
    }
}
