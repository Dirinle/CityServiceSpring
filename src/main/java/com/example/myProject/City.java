package com.example.myProject;


import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;


@Component
@Entity
public class City {
    @Id
    private String name;
    private Integer population;
    private String country;

    public City() {
    }

    public City(String name, Integer population, String country) {

        this.name = name;
        this.population = population;
        this.country = country;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name+" with "+ population+" population\n";
    }
}
