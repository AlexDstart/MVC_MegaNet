package ru.alexdstart.mvc_meganet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexdstart.mvc_meganet.entity.Statement;
import ru.alexdstart.mvc_meganet.entity.Status;
import ru.alexdstart.mvc_meganet.entity.dto.StatementFormDTO;
import ru.alexdstart.mvc_meganet.mapper.StatementMapper;
import ru.alexdstart.mvc_meganet.repository.StatementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {
    private final StatementRepository statementRepository;
    private final StatementMapper statementMapper;

    @Override
    public Statement save(StatementFormDTO statementFormDTO) {
        Statement statement = statementMapper.toEntity(statementFormDTO);
        statement.setDateCreate(LocalDate.now());
        statement.setStatus(Status.WORKING);
        return statementRepository.save(statement);
    }
    @Override
    public List<Statement> findAllStatements() {
        return statementRepository.findAll();  // Возвращает список всех заявок
    }

    @Override
    public void deleteStatement(long id) {
        statementRepository.deleteById(id);
    }

    //    @Override
//    public Statement mappingStatementFromDtoInStatement(StatementFormDTO statementFormDTO) {
//       Statement statement = new Statement();
//
//       statement.setCity(statementFormDTO.getCity());
//       statement.setStreet(statementFormDTO.getStreet());
//       statement.setHomeNumber(statementFormDTO.getHomeNumber());
//       statement.setMobileNumber(statementFormDTO.getMobileNumber());
//       statement.setDescription(statementFormDTO.getDescription());
//       statement.setTariff(statementFormDTO.getTariff());
//       statement.setName(statementFormDTO.getName());
//
//       return statement;
//    }
}
