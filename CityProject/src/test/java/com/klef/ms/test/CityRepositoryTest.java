package com.klef.ms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;

import com.klef.ms.CityProjectApplication;
import com.klef.ms.entity.City;
import com.klef.ms.repository.CityRepository;

@DataJpaTest
@ContextConfiguration(classes = CityProjectApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CityRepositoryTest {

    @Autowired
    private CityRepository repository;

    @Test
    void testFindCityById() {
        Optional<City> city = repository.findById(1L);
        assertTrue(city.isPresent());
    }

    @Test
    void testFindAllCities() {
        List<City> cities = repository.findAll();
        assertNotNull(cities);
    }

    @Test
    void testFindCityByName() {
        List<City> cities = repository.findByName("Hyderabad");
        assertNotNull(cities);
        assertFalse(cities.isEmpty());
    }

    @Test
    void testFindCityByType() {
        List<City> cities = repository.findByType("Metro");
        assertNotNull(cities);
    }

    @Test
    void testTotalCityCount() {
        long count = repository.count();
        System.out.println("Total City Count: " + count);
        assertTrue(count >= 0);
    }
}