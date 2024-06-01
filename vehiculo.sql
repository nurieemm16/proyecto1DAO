CREATE DATABASE vehiculo;

USE vehiculo;

CREATE TABLE vehiculo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    potencia INT NOT NULL,
    fechaCompra VARCHAR(50) NOT NULL
);



Select * FROM vehiculo;

INSERT INTO vehiculo (tipo, marca, potencia, fechaCompra) VALUES
('coche', 'Toyota', 150, '10-01-2001'),
('coche', 'Honda', 140, '12-02-2002'),
('coche', 'Ford', 200, '13-03-2013'),
('coche', 'Chevrolet', 180, '14-04-2024');


