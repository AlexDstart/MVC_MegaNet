package ru.alexdstart.mvc_meganet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexdstart.mvc_meganet.entity.City;
import ru.alexdstart.mvc_meganet.service.CityService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @GetMapping
    public String showCities(Model model) {
        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        return "Cities";
    }
}