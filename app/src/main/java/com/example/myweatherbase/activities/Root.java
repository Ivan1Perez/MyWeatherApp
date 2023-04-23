package com.example.myweatherbase.activities;

// Class obtained from https://json2csharp.com/code-converters/json-to-pojo
// and modified by adding Serializable interface

import java.io.Serializable;
import java.util.ArrayList;

class Main implements Serializable{
    public double temp;
    public double feels_like;
    public double temp_min;
    public double temp_max;
    public int pressure;
    public int sea_level;
    public int grnd_level;
    public int humidity;
    public double temp_kf;
}

class Weather implements Serializable{
    public int id;
    public String main;
    public String description;
    public String icon;
    public String getDescription() {
        return description;
    }
}

class Clouds implements Serializable{
    public int all;
}

class Wind implements Serializable{
    public double speed;
    public int deg;
    public double gust;
}

class Sys implements Serializable{
    public String pod;
}

class Rain implements Serializable{
    public double _3h;
}

class List implements Serializable{
    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public int visibility;
    public double pop;
    public Sys sys;
    public String dt_txt;
    public Rain rain;
    public ArrayList<Weather> getWeather() {
        return weather;
    }
    public String getDt_txt(){
        return dt_txt;
    }
}

class Coord implements Serializable{
    public double lat;
    public double lon;
}

class City implements Serializable {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;
    public int timezone;
    public int sunrise;
    public int sunset;
    public String getName() {
        return name;
    }
}

public class Root implements Serializable {
    public String cod;
    public int message;
    public int cnt;
    public ArrayList<List> list;
    public City city;

    public String getCity(){
        return city.name;
    }
    public int getTimeZone(){
        return city.timezone;
    }

    public ArrayList<List> getList() {
        return list;
    }
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
class LocalNames implements Serializable{
    public String et;
    public String fy;
    public String de;
    public String it;
    public String uz;
    public String bo;
    public String km;
    public String es;
    public String tw;
    public String ie;
    public String ps;
    public String eu;
    public String ee;
    public String bh;
    public String mk;
    public String qu;
    public String co;
    public String sd;
    public String cu;
    public String sl;
    public String so;
    public String ce;
    public String ig;
    public String ab;
    public String zu;
    public String sh;
    public String jv;
    public String ne;
    public String gv;
    public String bs;
    public String myto;
    public String my;
    public String na;
    public String fr;
    public String lo;
    public String ja;
    public String ca;
    public String pt;
    public String am;
    public String mr;
    public String ml;
    public String ug;
    public String ru;
    public String lt;
    public String rm;
    public String wa;
    public String be;
    public String eo;
    public String mt;
    public String gd;
    public String vo;
    public String sq;
    public String bn;
    public String ku;
    public String af;
    public String yi;
    public String bm;
    public String gl;
    public String ascii;
    public String kn;
    public String az;
    public String sa;
    public String ro;
    public String fi;
    public String fj;
    public String el;
    public String pa;
    public String lb;
    public String zh;
    public String sv;
    public String ms;
    public String bi;
    public String da;
    public String av;
    public String ky;
    public String cy;
    public String tg;
    public String hr;
    public String sw;
    public String ha;
    public String yo;
    public String tr;
    public String tk;
    public String hu;
    public String fo;
    public String kw;
    public String sr;
    public String cs;
    public String su;
    public String ko;
    public String ln;
    public String io;
    public String sk;
    public String ht;
    public String se;
    public String sm;
    public String en;
    public String ny;
    public String mn;
    public String te;
    public String ka;
    public String ar;
    public String om;
    public String ba;
    public String no;
    public String nn;
    public String hy;
    public String ia;
    public String os;
    public String uk;
    public String cv;
    public String nv;
    public String hi;
    public String ta;
    public String he;
    public String gu;
    public String bg;
    public String mi;
    public String ff;
    public String fa;
    public String ga;
    public String wo;
    public String tl;
    public String or;
    public String mg;
    public String si;
    public String is;
    public String tt;
    public String kk;
    public String br;
    public String kv;
    public String vi;
    public String gn;
    public String id;
    public String oc;
    public String ay;
    public String ur;
    public String lv;
    public String an;
    public String th;
    public String li;
    public String nl;
    public String pl;
    public String sc;
    public String kl;
    public String st;
    public String sn;
    public String feature_name;
}

class RootLatLonByName implements Serializable{
    public String name;
    public LocalNames local_names;
    public double lat;
    public double lon;
    public String country;
    public String state;
}


