# Coljuegos CRUD

Crud para la tabla USUARIO_COLJUEGOS

## Requisitos

- [PostgreSQL](https://www.postgresql.org/download/)
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

## Instalación

Sigue los pasos a continuación para configurar e inicializar el proyecto.

### 1. Clonar el repositorio

Clona este repositorio en tu máquina local usando el siguiente comando:

```bash
git clone https://github.com/cosia/Coljuegos.git
cd Coljuegos
```

### 2. Crear la base de datos

Abre PostgreSQL y crea una nueva base de datos llamada coljuegos:

```bash
CREATE DATABASE coljuegos;
```

### 3. Actualizar las credenciales de la conexion a la base de datos

Abre el archivo application.yml y actualiza con tus credenciales

```yml
username: [TU USUARIO]
password: [TU CONTRASEÑA]
```

### 4. Ejecutar la applicación