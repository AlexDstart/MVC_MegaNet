package ru.alexdstart.mvc_meganet.repository;

import ru.alexdstart.mvc_meganet.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement,Long> {

    List<Statement> findAll();
}
