package ru.alexdstart.mvc_meganet.mapper;

import org.mapstruct.Mapper;
import ru.alexdstart.mvc_meganet.entity.Statement;
import ru.alexdstart.mvc_meganet.entity.dto.StatementFormDTO;

@Mapper(componentModel = "spring")
public interface StatementMapper {

    Statement toEntity(final StatementFormDTO statementFormDTO);
    StatementFormDTO toDTO(final Statement statement);

}
