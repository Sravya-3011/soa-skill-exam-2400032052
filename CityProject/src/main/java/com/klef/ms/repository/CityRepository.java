package com.klef.ms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klef.ms.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByName(String name);

    List<City> findByType(String type);
}