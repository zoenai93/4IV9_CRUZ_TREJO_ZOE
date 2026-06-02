CREATE DATABASE biblioteca_lectura;

USE biblioteca_lectura;

CREATE TABLE libros(

    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    genero VARCHAR(50),
    anio INT

);

CREATE TABLE usuarios(

    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    edad INT,
    correo VARCHAR(100)

);

CREATE TABLE prestamos(

    id_prestamo INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT,
    id_libro INT,
    fecha_prestamo DATE,

    FOREIGN KEY(id_usuario)
    REFERENCES usuarios(id_usuario),

    FOREIGN KEY(id_libro)
    REFERENCES libros(id_libro)

);

INSERT INTO libros(titulo,autor,genero,anio)
VALUES
('Boulevard','Flor M. Salvador','Romance',2020),
('Invisible','Eloy Moreno','Drama',2018),
('El Principito','Antoine de Saint-Exupery','Fantasia',1943),
('Bajo la misma estrella','John Green','Romance',2012),
('La ladrona de libros','Markus Zusak','Drama',2005);

INSERT INTO usuarios(nombre,edad,correo)
VALUES
('Zoe',16,'zoe@gmail.com'),
('Ana',17,'ana@gmail.com'),
('Luis',15,'luis@gmail.com'),
('Sofia',16,'sofia@gmail.com'),
('Diego',17,'diego@gmail.com');

INSERT INTO prestamos(id_usuario,id_libro,fecha_prestamo)
VALUES
(1,2,'2026-06-01'),
(2,1,'2026-06-02'),
(3,4,'2026-06-03'),
(4,3,'2026-06-04'),
(5,5,'2026-06-05');