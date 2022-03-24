CREATE DATABASE IF NOT EXISTS PairBank;

USE PairBank;

CREATE TABLE IF NOT EXISTS agencia
(
    nome        VARCHAR(30),
    numero      VARCHAR(30),
    nomeGerente VARCHAR(50),
    PRIMARY KEY (numero)
);
CREATE TABLE IF NOT EXISTS gerente(
  CPF  VARCHAR(11) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  dataNascimento VARCHAR(20),
  senha VARCHAR(45),
  numeroAgencia VARCHAR(30),
  numeroTelefone VARCHAR(30),
  PRIMARY KEY (CPF),
  FOREIGN KEY (numeroAgencia) REFERENCES agencia(numero)
);

CREATE TABLE IF NOT EXISTS  cliente(
   CPF VARCHAR(11) NOT NULL,
   nome VARCHAR(50) NOT NULL,
   salario DOUBLE,
   dataNascimento VARCHAR(20),
   agencia VARCHAR(50) NOT NULL,
   conta VARCHAR(45),
   senha VARCHAR(50) NOT NULL,
   dataCriacaoConta VARCHAR(20),
   tipoConta VARCHAR(20),
   PRIMARY KEY(CPF),
   FOREIGN KEY (agencia) REFERENCES agencia(numero)
);

CREATE TABLE IF NOT EXISTS contaCorrente(
    valorCorrente double,
    CPFC VARCHAR(11),
    PRIMARY KEY (CPFC),
    FOREIGN KEY(CPFC) REFERENCES cliente(CPF)
);

CREATE TABLE IF NOT EXISTS contaPoupanca(
    valorPoupanca double,
    CPFP VARCHAR(11),
    PRIMARY KEY (CPFP),
    FOREIGN KEY (CPFP) REFERENCES cliente(CPF)
);

INSERT INTO  agencia(nome, numero, nomeGerente)
VALUES ('Betim - (MG)','001','Caio Andrada'),
       ('Florestal - (MG)','002','Erika Carvalho'),
       ('Juatuba - (MG)','003','Tyfany Wesley');

INSERT INTO gerente(cpf, nome, datanascimento, senha, numeroagencia)
VALUES ('91744412057','Caio Andrada','1989-12-12','Geren0001','001'),
       ('73031460081','Erika Carvalho','1978-02-10','Geren0002','002'),
       ('76796424000','Tyfany Wesley','1978-02-10','Geren0003','003');

INSERT INTO cliente(cpf, nome, salario, datanascimento, agencia, conta, senha, datacriacaoconta, tipoconta)
VALUES ('04582568203','Gabriel Vitor',1500,'1999-12-12','001','001','Ccfpoo1','2022-04-02','corrente'),
       ('13816201679','Pedro Maia',2000,'2001-12-18','001','002','Ccfpoo2','2022-02-05','corrente'),
       ('83838198204','Juscelia',2500,'1979-03-10','002','001','Ccfpoo3','2022-02-01','corrente'),
       ('24687049672','Jade Picon',3000,'2000-03-10','002','002','Ccfpoo4','2022-03-10','corrente'),
       ('13322742695','Érike Augusto',5000,'2000-12-02','003','001','Ccfpoo5','2022-03-11', 'poupanca'),
       ('65345398615','Sarah Felipe',2000,'1970-12-06','003','002','Ccfpoo6','2022-01-02', 'poupanca');

INSERT INTO contacorrente(valorCorrente, CPFC)
VALUES (0,'04582568203'),
       (0,'13816201679'),
       (0,'83838198204'),
       (0,'24687049672');

INSERT INTO contapoupanca(valorPoupanca, CPFP)
VALUES (0,'13322742695'),
       (0,'65345398615');

UPDATE gerente
SET numeroTelefone = 3198623548
WHERE CPF = 73031460081;

UPDATE gerente
SET numeroTelefone = 31998145443
WHERE CPF = 76796424000;

UPDATE gerente
SET numeroTelefone = 31914236985
WHERE CPF = 91744412057;


CREATE TABLE IF NOT EXISTS extrato(
          id INT NOT NULL,
          descricao VARCHAR(45),
          data VARCHAR(20),
          valor varchar(20),
          PRIMARY KEY(id)
);

CREATE TABLE  IF NOT EXISTS extrato_cliente(
           id INT NOT NULL,
           cpf varchar(11) NOT NULL,
           PRIMARY KEY (id, cpf),
           Foreign Key(id) REFERENCES extrato(id),
           FOREIGN KEY (cpf) REFERENCES cliente(CPF)
);

INSERT INTO extrato(id, descricao, data, valor)
VALUES (1,'Saque','2022-03-02','50'),
       (2,'Deposito','2022-03-02','20');

INSERT INTO extrato(id, descricao, data, valor)
VALUES (3, 'Pix','2022-03-18', '40');

INSERT INTO extrato_cliente(id, cpf)
VALUES (1, '04582568203'),
       (2, '04582568203');

INSERT INTO extrato_cliente(id, cpf)
VALUES (3, '83838198204');



