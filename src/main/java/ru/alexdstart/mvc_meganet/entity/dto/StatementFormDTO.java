package ru.alexdstart.mvc_meganet.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexdstart.mvc_meganet.entity.Status;
import ru.alexdstart.mvc_meganet.entity.Tariff;

import java.time.LocalDate;


@NoArgsConstructor
@Data
public class StatementFormDTO {
    private String city;
    private String name;
    private String street;
    private String homeNumber;
    private String mobileNumber;
    private String description;
    private Tariff tariff;
}
