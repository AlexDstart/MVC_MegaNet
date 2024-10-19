package ru.alexdstart.mvc_meganet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexdstart.mvc_meganet.entity.City;
import ru.alexdstart.mvc_meganet.repository.CityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }


}
