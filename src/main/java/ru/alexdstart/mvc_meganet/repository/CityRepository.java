package ru.alexdstart.mvc_meganet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexdstart.mvc_meganet.entity.City;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    Optional<City> findByCityName(String cityName);
}
