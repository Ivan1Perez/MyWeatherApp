package com.example.myweatherbase.base;

public class Parameters {
    public final static String API = "53ec00055c76807175c7b01564a7752a";
    public final static String LANG = "en";
    public final static String UNITS = "metric";
    public final static String URL = "https://api.openweathermap.org/data/2.5/";
    public final static String URL_OPTIONS =   "forecast?appid=" + API + "&lang=" + LANG + "&units=" + UNITS;
    public final static String ICON_URL_PRE = "http://openweathermap.org/img/wn/";
    public static final String ICON_URL_POST = "@2x.png";
    public final static String URL_CITY_NAME_PRE = "http://api.openweathermap.org/geo/1.0/direct?q=";
    public final static String URL_CITY_NAME_POST = "&limit=1&appid=" + API;

}
