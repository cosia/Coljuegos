package com.coljuegos.crud.service;

import com.coljuegos.crud.model.entity.UsuarioColjuegoEntity;

import java.util.List;

public interface UsuarioColjuegoService {
    List<UsuarioColjuegoEntity> findAll();

    UsuarioColjuegoEntity findById(Long id);

    UsuarioColjuegoEntity create(UsuarioColjuegoEntity entity);

    UsuarioColjuegoEntity update(Long id, UsuarioColjuegoEntity entity);

    void delete(Long id);
}
