package com.example.myweatherbase.activities;

public class Ciudad {

    private String cityName;
    private String countryName;
    private String image;
    private String locationPath;

    public Ciudad(String cityName, String countryName, String image, String locationPath) {
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

    public String getImage() {
        return image;
    }

    public String getLocationPath() {
        return locationPath;
    }
}
