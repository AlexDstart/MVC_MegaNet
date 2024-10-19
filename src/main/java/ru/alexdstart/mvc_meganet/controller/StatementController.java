package ru.alexdstart.mvc_meganet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import ru.alexdstart.mvc_meganet.entity.City;
import ru.alexdstart.mvc_meganet.entity.Statement;
import ru.alexdstart.mvc_meganet.entity.dto.StatementFormDTO;
import ru.alexdstart.mvc_meganet.repository.StatementRepository;
import ru.alexdstart.mvc_meganet.service.CityService;
import ru.alexdstart.mvc_meganet.service.StatementService;
import ru.alexdstart.mvc_meganet.service.StatementServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/statement")

public class StatementController {
    private StatementService statementService;
    private CityService cityService;


    public StatementController(StatementServiceImpl statementService, CityService cityService) {
        this.statementService = statementService;
        this.cityService = cityService;

    }


    @GetMapping("/new")
    public String newStatement(Model model) {
       List<City> cityList= cityService.findAllCities();

       List<String> cities = cityList.stream()
               .map(City::getCityName)
               .toList();

        model.addAttribute("cities", cities);
        model.addAttribute("statementFormDto", new StatementFormDTO());

        return "NewStatement";
    }

    @PostMapping("/new")
    public String saveStatement(
            @ModelAttribute StatementFormDTO statementFormDTO,
            Model model) {
        // Сохраняем заявку
        statementService.save(statementFormDTO);


        //плучить список всех городов из бд
        //проверить то что ввел пользователь если этот город обслуживается тоесть в с этом списке то продолжить добавлять в заявку
        //иначе вернуть на страницу добавления и указать в модел сообщение об ошибке

        // Добавляем объект в модель для отображения на странице
        model.addAttribute("statementFormDto", statementFormDTO);

        return "StatementDone"; // возвращаем на страницу с подтверждением
    }


    @PostMapping("/delete")
    public String deleteStatement(@RequestParam long id) {
        statementService.deleteStatement(id);
        return "redirect:/statement/all";
    }

    @GetMapping("/done")
    public String showStatementDone(Model model) {
        StatementFormDTO statementFormDto = new StatementFormDTO(); // Замените на реальную логику получения объекта
        model.addAttribute("statementFormDto", statementFormDto);
        return "StatementDone";
    }

    @GetMapping("/all")
    public String showAllStatements(Model model) {
        // Получаем список всех заявок из сервиса
        List<Statement> statements = statementService.findAllStatements();
        // Добавляем этот список в модель
        model.addAttribute("statements", statements);
        // Возвращаем название шаблона для отображения списка заявок
        return "Statements";  // Страница, которая отобразит список заявок
    }





}





