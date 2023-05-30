set foreign_key_checks = 0;

delete from funcionarios;

set foreign_key_checks = 1;

alter table funcionarios auto_increment = 1;

insert into funcionarios (nome, cargo, departamento, data_admissao, salario, contato) values ('Samuel', 'Estagiário', 'Desenvolvimento de Software', '2023-06-01', 2000, '+55 (19) 99829-1686');