package ru.alexdstart.mvc_meganet.service;

import ru.alexdstart.mvc_meganet.entity.Statement;
import ru.alexdstart.mvc_meganet.entity.dto.StatementFormDTO;
import ru.alexdstart.mvc_meganet.repository.StatementRepository;

import java.util.List;

public interface StatementService {
    Statement save(StatementFormDTO statementFormDTO);

    List<Statement> findAllStatements();

    void deleteStatement(long id);

}
