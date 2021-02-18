# cineProyectoSpring
BD:

CREATE DATABASE proyectocine;
USE proyectocine;

CREATE TABLE tbl_rol(id_rol INT AUTO_INCREMENT PRIMARY KEY,rol VARCHAR(10));
CREATE TABLE tbl_usuario(id_usuario INT AUTO_INCREMENT PRIMARY KEY,id_rol int,usuario VARCHAR(30),PASSWORD varchar(60),FOREIGN KEY(id_rol) REFERENCES tbl_rol(id_rol));
CREATE TABLE tbl_galeria(id_galeria INT AUTO_INCREMENT PRIMARY KEY,id_usuario INT,FOREIGN KEY(id_usuario) REFERENCES tbl_usuario(id_usuario));
CREATE TABLE tbl_pelicula(id_pelicula INT AUTO_INCREMENT PRIMARY KEY,nombre VARCHAR(50),descripcion VARCHAR(50),sinopsis VARCHAR(50),fecha_estreno DATE,imagen VARCHAR(100),trailer VARCHAR(100),categoria VARCHAR(10));
CREATE TABLE tbl_galeria_pelicula(id_galeria_pelicula INT AUTO_INCREMENT PRIMARY KEY,id_pelicula INT, id_galeria INT,FOREIGN KEY(id_pelicula) REFERENCES tbl_pelicula(id_pelicula),FOREIGN KEY(id_galeria)REFERENCES tbl_galeria(id_galeria));


importante:

insert into tbl_rol () VALUES (1,"ROLE_ADMIN");
insert into tbl_rol () VALUES (2,"ROLE_USER");
