package com.klef.ms.service;

import java.util.List;
import com.klef.ms.entity.City;

public interface CityService {

    City addCity(City city);

    List<City> displayAllCities();

    City displayCityById(Long id);

    City updateCity(City city);

    String deleteCity(Long id);

    List<City> displayByName(String name);

    List<City> displayByType(String type);
}