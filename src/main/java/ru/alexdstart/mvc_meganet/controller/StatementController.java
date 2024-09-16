package ru.alexdstart.mvc_meganet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexdstart.mvc_meganet.entity.Statement;
import ru.alexdstart.mvc_meganet.entity.dto.StatementFormDTO;
import ru.alexdstart.mvc_meganet.service.StatementServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/statement")
public class StatementController {
    private StatementServiceImpl statementService;

    public StatementController(StatementServiceImpl statementService) {
        this.statementService = statementService;
    }

    @GetMapping("/new")
    public String newStatement(Model model) {
        model.addAttribute("statementFormDto", new StatementFormDTO());
        return "NewStatement";
    }

    @PostMapping("/new")
    public String saveStatement(
            @ModelAttribute StatementFormDTO statementFormDTO,
            Model model) {
        // Сохраняем заявку
        statementService.save(statementFormDTO);

        // Добавляем объект в модель для отображения на странице
        model.addAttribute("statementFormDto", statementFormDTO);

        return "StatementDone"; // возвращаем на страницу с подтверждением
    }

    @GetMapping("/done")
    public String showStatementDone(Model model) {
        StatementFormDTO statementFormDto = new StatementFormDTO(); // Замените на реальную логику получения объекта
        model.addAttribute("statementFormDto", statementFormDto);
        return "StatementDone";
    }
    @PostMapping("/statement/submit")
    public String submitStatement(@ModelAttribute("statementFormDto") StatementFormDTO statementFormDto, Model model) {
        // Добавляем объект в модель
        model.addAttribute("statementFormDto", statementFormDto);
        // Возвращаем страницу с подтверждением
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





