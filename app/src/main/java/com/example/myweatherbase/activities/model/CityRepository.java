package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.Ciudad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepository {

    private List<Ciudad> savedCities;

    private static CityRepository instance;

    private CityRepository(){
        savedCities = new ArrayList<>();

        savedCities.add(new Ciudad("Saved cities", "", "https://www.spain.info/export/sites/segtur/.content/imagenes/cabeceras-grandes/valencia/ciudad-artes-ciencias-valencia-c-luca-bravo-u-UyUjtbu5vj4.jpg_604889389.jpg", ""));
        savedCities.add(new Ciudad("Valencia", "Spain", "https://www.spain.info/export/sites/segtur/.content/imagenes/cabeceras-grandes/valencia/ciudad-artes-ciencias-valencia-c-luca-bravo-u-UyUjtbu5vj4.jpg_604889389.jpg", "&lat=39.4079343&lon=-0.5263244"));
        savedCities.add(new Ciudad("Madrid", "Spain", "https://www.spain.info/export/sites/segtur/.content/imagenes/cabeceras-grandes/valencia/ciudad-artes-ciencias-valencia-c-luca-bravo-u-UyUjtbu5vj4.jpg_604889389.jpg","&lat=39.5877978&lon=-0.5382208"));
        savedCities.add(new Ciudad("Barcelona", "Spain", "https://www.spain.info/export/sites/segtur/.content/imagenes/cabeceras-grandes/valencia/ciudad-artes-ciencias-valencia-c-luca-bravo-u-UyUjtbu5vj4.jpg_604889389.jpg", "&lat=39.5877978&lon=-0.5382208"));
        savedCities.add(new Ciudad("IES La Vereda", "Spain", "https://www.spain.info/export/sites/segtur/.content/imagenes/cabeceras-grandes/valencia/ciudad-artes-ciencias-valencia-c-luca-bravo-u-UyUjtbu5vj4.jpg_604889389.jpg", "&lat=39.5877978&lon=-0.5382208"));
        savedCities.add(new Ciudad("Reykjavík", "Iceland", "https://www.spain.info/export/sites/segtur/.content/imagenes/cabeceras-grandes/valencia/ciudad-artes-ciencias-valencia-c-luca-bravo-u-UyUjtbu5vj4.jpg_604889389.jpg", "&lat=64.1333414&lon=-22.1477567"));
    }

    public static CityRepository getInstance(){
        if(instance==null)
            instance = new CityRepository();

        return instance;
    }

    public List<Ciudad> getAll(){
        return new ArrayList<>(savedCities);
    }

    public Ciudad getCityByName(String name){
        Optional<Ciudad> optionalProfesion = savedCities.stream()
                .filter(p->p.getCityName().equals(name))
                .findFirst();

        if(optionalProfesion.isPresent())
            return optionalProfesion.get();

        return null;
    }
}
