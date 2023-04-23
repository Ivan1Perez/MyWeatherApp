package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.SavedCity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository {

    private List<SavedCity> savedCities;

    private static CityRepository instance;

    private CityRepository(){
        savedCities = new ArrayList<>();

        savedCities.add(new SavedCity("Saved cities", "", R.drawable.defaultcity1, ""));
        savedCities.add(new SavedCity("Valencia", "Spain", R.drawable.valencia, "&lat=39.4079343&lon=-0.5263244"));
        savedCities.add(new SavedCity("Madrid", "Spain", R.drawable.madrid, "&lat=39.5877978&lon=-0.5382208"));
        savedCities.add(new SavedCity("Barcelona", "Spain", R.drawable.barcelona, "&lat=39.5877978&lon=-0.5382208"));
        savedCities.add(new SavedCity("IES La Vereda", "Spain", R.drawable.ieslavereda, "&lat=39.5877978&lon=-0.5382208"));
        savedCities.add(new SavedCity("Reykjavík", "Iceland", R.drawable.reykjavik, "&lat=64.1333414&lon=-22.1477567"));
    }

    public static CityRepository getInstance(){
        if(instance==null)
            instance = new CityRepository();

        return instance;
    }

    public List<SavedCity> getAll(){
        return new ArrayList<>(savedCities);
    }

    public SavedCity getCityByName(String name){
        Optional<SavedCity> optionalProfesion = savedCities.stream()
                .filter(p->p.getCityName().equals(name))
                .findFirst();

        if(optionalProfesion.isPresent())
            return optionalProfesion.get();

        return null;
    }
}
