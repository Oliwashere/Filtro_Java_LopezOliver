create database NarutozzzZ;

use NarutozzzZ;

create table Ninja(
ID int not null primary key auto_increment,
Nombre varchar(45) not null,
Rango varchar(45) not null,
Aldea varchar(45) not null
);

create table Habilidad(
ID_Ninja int not null,
Nombre varchar(45) not null,
Descripcion varchar(100) not null,
foreign key (ID_Ninja) references Ninja(ID)
);

create table Mision(
ID int not null primary key auto_increment,
Descripcion varchar(100) not null,
Rango varchar(45) not null,
Recompensa int not null
);

create table MisionNinja(
ID_Ninja int not null,
ID_Mision int not null,
FechaInicio date not null,
FechaFin date not null,
Habilidad varchar(45), 
primary key (ID_Ninja, ID_Mision),
foreign key (ID_Ninja) references Ninja(ID),
foreign key (ID_Ninja) references Ninja(ID)
);

