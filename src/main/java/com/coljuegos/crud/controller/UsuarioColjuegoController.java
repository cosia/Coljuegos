package com.coljuegos.crud.controller;

import com.coljuegos.crud.controller.mapper.UsuarioColjuegoMapper;
import com.coljuegos.crud.model.dto.UsuarioColjuegoDTO;
import com.coljuegos.crud.model.entity.UsuarioColjuegoEntity;
import com.coljuegos.crud.service.UsuarioColjuegoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping(value = "usuarios")
public class UsuarioColjuegoController {

    private final UsuarioColjuegoMapper mapper;
    private final UsuarioColjuegoService service;

    @GetMapping
    public ResponseEntity<List<UsuarioColjuegoDTO>> getAll(){
        log.info("UsuarioColjuegoController.getAll");
        List<UsuarioColjuegoDTO> usuarios = this.service.findAll().stream().map(mapper::toDto).toList();
        log.debug("usuarios mappers: {}", usuarios);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UsuarioColjuegoDTO> findById(@PathVariable Long id){
        log.info("UsuarioColjuegoController.findById id: {}", id);
        UsuarioColjuegoEntity entity = this.service.findById(id);
        return ResponseEntity.ok(this.mapper.toDto(entity));
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioColjuegoDTO> create(@RequestBody UsuarioColjuegoDTO dto){
        log.info("UsuarioColjuegoController.create");
        UsuarioColjuegoEntity entity = this.mapper.toEntity(dto);
        UsuarioColjuegoEntity newEntity = this.service.create(entity);
        return ResponseEntity.created(URI.create(String.format("/usuarios/%s", dto.getId()))).body(mapper.toDto(newEntity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UsuarioColjuegoDTO> update(@PathVariable Long id, @RequestBody UsuarioColjuegoDTO dto){
        log.info("UsuarioColjuegoController.update id: {}", id);
        UsuarioColjuegoEntity entity = this.mapper.toEntity(dto);
        UsuarioColjuegoEntity newEntity = this.service.update(id, entity);
        return ResponseEntity.ok(mapper.toDto(newEntity));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        log.info("UsuarioColjuegoController.delete id: {}", id);
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }
}
