package com.coljuegos.crud.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UsuarioColjuegoDTO implements Serializable {
    private Long id;
    private String nombre;
    private String correo;
    private String password;
    private LocalDateTime fechaRegistro = LocalDateTime.now();
}
