
package com.klef.ms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.ms.entity.City;
import com.klef.ms.service.CityService;

@RestController
@RequestMapping("/")
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public String test() {
        return "Hearty Welcome to City";
    }

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City c = service.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<City>> displayAllCities() {
        return ResponseEntity.ok(service.displayAllCities());
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<?> displayCityById(@PathVariable Long id) {
        City city = service.displayCityById(id);
        if (city != null) {
            return ResponseEntity.ok(city);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City ID Not Found");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCity(@RequestBody City city) {
        City c = service.updateCity(city);
        if (c != null) {
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City ID Not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        String message = service.deleteCity(id);
        if (message.equals("City Deleted Successfully")) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<City>> displayByName(@PathVariable String name) {
        return ResponseEntity.ok(service.displayByName(name));
    }

    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<City>> displayByType(@PathVariable String type) {
        return ResponseEntity.ok(service.displayByType(type));
    }
}
