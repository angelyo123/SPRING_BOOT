create database BD_T1_Empleados;

use BD_T1_Empleados;

create table Departamento (
	id int auto_increment primary key,
    nombre nvarchar(200) not null
);

create table Empleado (
	id int auto_increment primary key,
    nombre nvarchar(255) not null,
    apellido nvarchar(255) not null,
    salario decimal(10, 2) not null,
    id_departamento int,
    foreign key (id_departamento) references Departamento(id)
);

INSERT INTO Departamento (nombre) VALUES ('Recursos Humanos');
INSERT INTO Departamento (nombre) VALUES ('Tecnología');
INSERT INTO Departamento (nombre) VALUES ('Finanzas');
INSERT INTO Departamento (nombre) VALUES ('Marketing');
INSERT INTO Departamento (nombre) VALUES ('Ventas');


INSERT INTO Empleado (nombre, apellido, salario, id_departamento) VALUES ('Juan', 'Pérez', 3000.00, 1);
INSERT INTO Empleado (nombre, apellido, salario, id_departamento) VALUES ('Ana', 'García', 4500.00, 2);
INSERT INTO Empleado (nombre, apellido, salario, id_departamento) VALUES ('Luis', 'Martínez', 4000.00, 3);
INSERT INTO Empleado (nombre, apellido, salario, id_departamento) VALUES ('María', 'López', 3500.00, 4);
INSERT INTO Empleado (nombre, apellido, salario, id_departamento) VALUES ('Carlos', 'Sánchez', 3200.00, 5);


select*from Empleado;

select*from Departamento;

DROP table Empleado;
DROP table Departamento;




