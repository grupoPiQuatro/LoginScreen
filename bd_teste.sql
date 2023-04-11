use sprint;

create table usuario (
id int primary key auto_increment,
nome varchar(45),
email varchar(60),
senha varchar(45),
tipo varchar(5)
);

insert into usuario values (null, "monitor mind", "mm@email.com", "1234", "func");

select * from usuario;
select * from usuario where email = 'mm@email.com' and senha = '1234';