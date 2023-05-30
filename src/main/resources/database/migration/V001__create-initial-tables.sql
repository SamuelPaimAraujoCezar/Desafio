create table funcionarios (
  id bigint not null auto_increment,
  nome varchar(100) not null,
  cargo varchar(100) not null,
  departamento varchar(100) not null,
  data_admissao date not null,
  salario double not null,
  contato varchar(50),

  primary key (id)
) engine=InnoDB default charset=utf8;
