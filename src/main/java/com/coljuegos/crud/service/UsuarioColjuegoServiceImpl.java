package com.coljuegos.crud.service;

import com.coljuegos.crud.model.entity.UsuarioColjuegoEntity;
import com.coljuegos.crud.model.repository.UsuarioColjuegoRepositoy;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioColjuegoServiceImpl implements UsuarioColjuegoService{

    private final UsuarioColjuegoRepositoy repositoy;

    @Override
    public List<UsuarioColjuegoEntity> findAll() {
        return this.repositoy.findAll();
    }

    @Override
    public UsuarioColjuegoEntity findById(Long id) {
        return this.repositoy.findById(id).orElseThrow(()-> new EntityNotFoundException(id.toString()));
    }

    @Override
    public UsuarioColjuegoEntity create(UsuarioColjuegoEntity entity) {
        return this.repositoy.save(entity);
    }

    @Override
    public UsuarioColjuegoEntity update(Long id, UsuarioColjuegoEntity entity) {
        var found = this.findById(id);
        found.update(entity);
        return this.repositoy.save(found);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        this.repositoy.deleteById(id);
    }
}
