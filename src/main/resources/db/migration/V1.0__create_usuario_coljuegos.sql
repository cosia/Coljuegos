CREATE TABLE IF NOT EXISTS USUARIO_COLJUEGOS(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    correo varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    fecha_registro timestamp NOT NULL
)