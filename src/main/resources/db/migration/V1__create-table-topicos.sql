create table Tópico (

    id int primary key auto_increment not null,
    título varchar (255) not null,
    mensaje text not null,
    fecha_creación date not null,
    status_tópico varchar (50) not null,
    autor varchar (100),
    curso varchar (100)

);