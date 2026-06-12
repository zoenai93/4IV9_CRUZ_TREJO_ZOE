CREATE DATABASE biblioteca_lectura;

USE biblioteca_lectura;

CREATE TABLE libros(
    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    genero VARCHAR(50),
    anio INT
);

INSERT INTO libros(titulo,autor,genero,anio) VALUES
('Boulevard','Flor M. Salvador','Romance',2020),
('Invisible','Eloy Moreno','Drama',2018),
('El Principito','Antoine de Saint-Exupery','Fantasia',1943),
('Harry Potter','J.K. Rowling','Fantasia',1997),
('Coraline','Neil Gaiman','Fantasia',2002),
('1984','George Orwell','Ciencia Ficcion',1949),
('Orgullo y Prejuicio','Jane Austen','Romance',1813),
('Cumbres Borrascosas','Emily Bronte','Clasico',1847),
('Bajo la misma estrella','John Green','Romance',2012),
('La ladrona de libros','Markus Zusak','Drama',2005);