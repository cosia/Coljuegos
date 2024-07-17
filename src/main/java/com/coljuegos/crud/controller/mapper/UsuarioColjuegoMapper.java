package com.coljuegos.crud.controller.mapper;

import com.coljuegos.crud.model.dto.UsuarioColjuegoDTO;
import com.coljuegos.crud.model.entity.UsuarioColjuegoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsuarioColjuegoMapper {
    UsuarioColjuegoEntity toEntity(UsuarioColjuegoDTO dto);

    @Mapping(target = "password", ignore = true)
    UsuarioColjuegoDTO toDto(UsuarioColjuegoEntity entity);

}
