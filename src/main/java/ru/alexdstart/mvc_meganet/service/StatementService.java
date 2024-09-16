package service;

import org.springframework.stereotype.Service;
import repository.StatementRepository;
@Service
public class StatementService {
    StatementRepository statementRepository;
    public StatementService(StatementRepository statementRepository) {
        this.statementRepository = statementRepository;


    }

}
