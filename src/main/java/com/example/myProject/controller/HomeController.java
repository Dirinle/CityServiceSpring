package com.example.myProject.controller;

import com.example.myProject.City;
import com.example.myProject.service.CitySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    CitySevice citySevice;

    @Autowired
    City city;

    @RequestMapping ("/home")
    public String home (){
        return "It is home page";
    }

    @RequestMapping ("/cities")
    public String getAllCities(){
        return citySevice.getAllCities();
    }

    @RequestMapping ("/cities/{name}")
    public String getCity(@PathVariable String name){
        return citySevice.getCity(name);
    }

    @RequestMapping (method= RequestMethod.POST, value="/cities")
    public String addCity(@RequestBody City city){
        return citySevice.addCity(city)+" was added";
    }

    @RequestMapping (method= RequestMethod.PUT, value="/cities")
    public String updateCity(@RequestBody City city){
        return citySevice.updateCity(city)+" updated";
    }

    @RequestMapping (method= RequestMethod.DELETE, value="/cities")
    public String deleteCity(@RequestBody City city){
        return citySevice.deleteCity(city)+" deleted";
    }
}
