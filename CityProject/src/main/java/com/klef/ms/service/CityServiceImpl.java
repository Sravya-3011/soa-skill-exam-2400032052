package com.klef.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.ms.entity.City;
import com.klef.ms.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repo;

    @Override
    public City addCity(City city) {
        return repo.save(city);
    }

    @Override
    public List<City> displayAllCities() {
        return repo.findAll();
    }

    @Override
    public City displayCityById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public City updateCity(City city) {
        if (city.getCityId() == null) {
            return null;
        }

        City existingCity = repo.findById(city.getCityId()).orElse(null);

        if (existingCity == null) {
            return null;
        }

        existingCity.setName(city.getName());
        existingCity.setType(city.getType());
        existingCity.setStatus(city.getStatus());
        existingCity.setLocation(city.getLocation());

        return repo.save(existingCity);
    }
    @Override
    public String deleteCity(Long id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "City Deleted Successfully";
        }

        return "City ID Not Found";
    }

    @Override
    public List<City> displayByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<City> displayByType(String type) {
        return repo.findByType(type);
    }
}