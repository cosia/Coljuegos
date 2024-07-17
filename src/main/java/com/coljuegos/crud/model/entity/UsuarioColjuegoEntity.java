package com.coljuegos.crud.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO_COLJUEGOS")
@Getter
@Setter
public class UsuarioColjuegoEntity {

    @Id
    @Column( name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name= "fecha_registro", updatable = false, nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public void update(UsuarioColjuegoEntity entity){
        this.correo = entity.getCorreo();
        this.nombre = entity.getNombre();
        this.password = entity.getPassword();
    }
}
