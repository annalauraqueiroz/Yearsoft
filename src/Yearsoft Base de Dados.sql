create database yearsoftRefatoramento;
use yearsoftRefatoramento;

create table usuarios(
	nome varchar(35),
	login varchar(30),
	senha varchar(30),
    nascimento date,
    primary key (login)
)ENGINE = INNODB;

create table categorias(
	nome varchar(50),
    cor varchar(13),
    contraste int,
    loginProprietario varchar(30),
    primary key (nome, loginProprietario),
    foreign key (loginProprietario) references usuarios (login)
)Engine=INNODB;

create table eventos(
	idEvento int auto_increment,
	diaInicial date,
    diaFinal date,
    horaInicial int,
    minutoInicial int,
    horaFinal int,
    minutoFinal int,
    descricao varchar(150),
    importancia int,
    categoria varchar(50),
    loginProprietario varchar(30),
    PRIMARY KEY (idEvento),
    FOREIGN KEY (categoria) REFERENCES categorias (nome),
    FOREIGN KEY (loginProprietario) REFERENCES usuarios (login)
)Engine=INNODB;