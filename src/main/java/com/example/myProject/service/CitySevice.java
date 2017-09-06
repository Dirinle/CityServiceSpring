package com.example.myProject.service;

import com.example.myProject.City;
import com.example.myProject.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CitySevice {

    @Autowired
    CityRepository cityRepository;

    private List<City> cities;

    public String getAllCities() {
//        fillDefault();
        cities=new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        StringBuilder result = new StringBuilder("");
        cities.forEach(x -> result.append(" " + x.toString()));
//        return "zzz";
        return result.toString();
    }

    public String getCity(String id) {
        return cityRepository.findOne(id).toString();
//        return cities.stream().filter(z -> z.getName().equals(id)).findFirst().toString();
    }

    private void fillDefault() {
        if(cities==null){
            cities = new ArrayList<>();
            cities.add(new City("Paris", 30000, "France"));
            cities.add(new City("London", 50000, "GB"));
        }
    }

    public String addCity(City city) {
        cityRepository.save(city);
        return city.getName();
    }

    public String updateCity(City city){
//        cityRepository.delete(city.getName());
        cityRepository.save(city);
        return city.getName();
//        cities.forEach(s->{if(s.getName().equals(city.getName())) s=null;});
//        for (int i = 0; i < cities.size(); i++) {
//            if (cities.get(i).getName().equals(city.getName())) {
//                cities.set(i, city);
//                return cities.get(i).getName()+ " was";
//            }
//        }
//        return city.getName()+" not exist and was not";
    }
    public String deleteCity(City city){
        cityRepository.delete(city);
//        for (int i = 0; i < cities.size(); i++) {
//            if (cities.get(i).getName().equals(city.getName())) {
//                cities.remove(i);
//                return city.getName()+ " was";
//            }
//        }
//        return city.getName()+" not exist and was not";
        return city.getName();
    }
}
