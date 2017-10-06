drop database if exists TresMaria;
create database TresMaria;
use TresMaria;

CREATE TABLE Sexo (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Descricao VARCHAR(100) NOT NULL,
    Sigla CHAR NOT NULL,
    CONSTRAINT pk_Sexo PRIMARY KEY (Id)
);

insert into Sexo values ( null, 'Masculino', 'M');
insert into Sexo values ( null, 'Feminino', 'F');

CREATE TABLE Estado (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    CodigoUF BIGINT NOT NULL,
    Nome VARCHAR(200) NOT NULL,
    UF VARCHAR(2) NOT NULL,
    Regiao VARCHAR(100) NOT NULL,
    CONSTRAINT pk_Estado PRIMARY KEY (Id)
);

CREATE TABLE Cidade (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    IdEstado BIGINT NOT NULL,
    CodigoMunicipio BIGINT NOT NULL,
    Nome VARCHAR(300) NOT NULL,
    UF VARCHAR(2) NOT NULL,
    CONSTRAINT pk_Cidade PRIMARY KEY (Id),
    CONSTRAINT fk_Estado FOREIGN KEY (IdEstado)
        REFERENCES Estado (Id)
);

CREATE TABLE Endereco (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Logradouro VARCHAR(300) NOT NULL,
    Numero VARCHAR(10) NOT NULL,
    Complemento VARCHAR(100) NULL,
    IdCidade BIGINT NOT NULL,
    CONSTRAINT pk_Endereco PRIMARY KEY (Id),
    CONSTRAINT fk_Cidade FOREIGN KEY (IdCidade)
        REFERENCES Cidade (Id)
);

CREATE TABLE Pessoa (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    IdSexo BIGINT NOT NULL,
    IdEndereco BIGINT NOT NULL,
    DataHoraCadastro datetime not null default now(),
    NomeRazaoSocial varchar(350) not null,
    CONSTRAINT pk_Pessoa PRIMARY KEY (Id),
    CONSTRAINT fk_Endereco FOREIGN KEY (IdEndereco)
        REFERENCES Endereco (Id),
    CONSTRAINT fk_Sexo FOREIGN KEY (IdSexo)
        REFERENCES Sexo (Id)
);

CREATE TABLE PessoaJuridica (
    Id BIGINT NOT NULL,
    CNPJ VARCHAR(14) NOT NULL,
    IncricaoEstadual VARCHAR(19) NULL,
    CONSTRAINT pk_PessoaJuridica PRIMARY KEY (Id),
    CONSTRAINT fk_Pessoa1 FOREIGN KEY (Id)
        REFERENCES Pessoa (Id)
);

CREATE TABLE PessoaFisica (
    Id BIGINT NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    RG VARCHAR(10) NULL,
    CONSTRAINT pk_PessoaFisica PRIMARY KEY (Id),
    CONSTRAINT fk_Pessoa2 FOREIGN KEY (Id)
        REFERENCES Pessoa (Id)
);

CREATE TABLE TelefoneContato (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    DDD VARCHAR(4) NOT NULL,
    Numero VARCHAR(9) NOT NULL,
    CONSTRAINT pk_TelefoneContato PRIMARY KEY (Id)
);

CREATE TABLE Contato (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    DataHoraContato DATETIME NOT NULL,
    IdTelefoneContato BIGINT NOT NULL,
    IdPessoa bigint not null,
    CONSTRAINT pk_Contato PRIMARY KEY (Id),
    CONSTRAINT fk_TelefoneContato FOREIGN KEY (IdTelefoneContato)
        REFERENCES TelefoneContato (Id),
    CONSTRAINT fk_Pessoa3 FOREIGN KEY (IdPessoa)
        REFERENCES Pessoa (Id)
);

CREATE TABLE Situacao (
	Id BIGINT NOT NULL,
	Descricao VARCHAR(200) NOT NULL,
	CONSTRAINT pk_Situacao PRIMARY KEY(Id)
);
INSERT INTO Situacao (Id, Descricao) VALUES (1, "Ativo");
INSERT INTO Situacao (Id, Descricao) VALUES (2, "Inativo");
INSERT INTO Situacao (Id, Descricao) VALUES (3, "Cancelado");

CREATE TABLE Servico (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Descricao VARCHAR(300) NOT NULL,
    IdSituacao BIGINT NOT NULL,
    CONSTRAINT pk_Servico PRIMARY KEY (Id),
    CONSTRAINT fk_Sfituacao FOREIGN KEY (IdSituacao) REFERENCES Situacao (Id)
 );

CREATE TABLE Preco (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    IdServico BIGINT NOT NULL,
    Valor DECIMAL(11, 8) unsigned zerofill NOT NULL,
    DataHoraCadastro datetime not null default now(),
    DataHoraFimVigencia datetime null, 
    CONSTRAINT pk_Preco PRIMARY KEY (Id),
    CONSTRAINT fk_Servico1 FOREIGN KEY (IdServico)
        REFERENCES Servico (Id)
);

CREATE TABLE ContatoXServico (
    Id BIGINT NOT NULL AUTO_INCREMENT,
    IdContato bigint not null,
    IdServico BIGINT NOT NULL,
    CONSTRAINT pk_ContatoXServico PRIMARY KEY (Id),
    CONSTRAINT fk_Contato FOREIGN KEY (IdContato)
        REFERENCES Contato (Id),
    CONSTRAINT fk_Servico2 FOREIGN KEY (IdServico)
        REFERENCES Servico (Id)
);

insert into Servico values (null, 'Baby-care',1), (null, 'Limpeza',1);
insert into Preco values (null, 1, 100.00, now(), null), (null, 2, 130.00, now(), null);

select * from Servico