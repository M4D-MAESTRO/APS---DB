drop database if exists pdv;
CREATE DATABASE pdv;
USE pdv;

CREATE TABLE cliente(
	codcli int auto_increment not null,
    nome varchar(35),
    bonus long,
    perfil char,
    condicao char, /*nao da para deixar status, pois se trata de uma palavra reservada*/
    
    primary key(codcli)
);

CREATE TABLE localidade(
	codlocal int auto_increment not null,
    nome varchar(35),
    endereco varchar(80),
    telefone varchar(14),
    
    primary key (codlocal)
);

CREATE TABLE produto(
	codprod  int auto_increment not null,
    codlocal int,
    descricao varchar(35),
    qte_estoque long,
    preco_unitario double,
    
    primary key (codprod),
    foreign key (codlocal) references localidade(codlocal)
);

CREATE TABLE venda(
	codcli  int not null,
    codlocal int not null,
    codprod int not null,
    qte_venda long,
    valor_total double,
    data_venda date,
    
    primary key (codcli, codlocal, codprod),
    foreign key (codcli) references cliente(codcli),
    foreign key (codlocal) references localidade(codlocal),
    foreign key (codprod) references produto(codprod)
);

CREATE TABLE desconto(
	id_desconto int auto_increment,
    codprod int,
    percentual int,
    qtd_min long,
    qtd_max long,
    
    primary key (id_desconto),
    foreign key (codprod) references produto(codprod)
);

/*Cadastro dos clientes*/
INSERT INTO cliente(nome, bonus, perfil, condicao) VALUES ('Henrique', 100, 'G', 'A');
INSERT INTO cliente(nome, bonus, perfil, condicao) VALUES ('Ana', 150, 'M', 'A');
INSERT INTO cliente(nome, bonus, perfil, condicao) VALUES ('Lucas', 300, 'G', 'A');
INSERT INTO cliente(nome, bonus, perfil, condicao) VALUES ('Roberta', 1000, 'P', 'A');
INSERT INTO cliente(nome, bonus, perfil, condicao) VALUES ('Rómulo', 2000, 'G', 'A');
INSERT INTO cliente(nome, bonus, perfil, condicao) VALUES ('Carlos', 500, 'P', 'I');

/*Cadastro das localidades*/
INSERT INTO localidade(nome, endereco, telefone) VALUES ('Cascadura', 'Rua Sidónio Paes', '3200-0456');
INSERT INTO localidade(nome, endereco, telefone) VALUES ('Madureira', 'Av. Dom Hélder Câmara', '4000-0457');
INSERT INTO localidade(nome, endereco, telefone) VALUES ('Quintino', 'Rua Clarimundo de Melo', '3670-0458');
INSERT INTO localidade(nome, endereco, telefone) VALUES ('Méier', 'Rua Dias Cruz', '4109-0459');
INSERT INTO localidade(nome, endereco, telefone) VALUES ('Centro', 'Rua da Constituição', '4002-0560');

/*Cadastro dos produtos - 3 produtos para cada localização*/
/*Cascadura*/
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (1, 'Xbox One S', 100, 1200.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (1, 'Xbox One X', 30, 2400.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (1, 'TV 4K Sansung', 50, 3000.00);

/*Madureira*/
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (2, 'Rádio portátil JBL', 300, 200.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (2, 'Motorola Moto One', 150, 1500.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (2, 'IPhone X', 10, 5000.00);

/*Quintino*/
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (3, 'Controle Xbox One - Branco', 60, 180.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (3, 'Controle Xbox One - Preto', 80, 150.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (3, 'Joystick para Smarthphone', 10, 60.00);

/*Méier*/
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (4, 'Xbox Live Gold - 12 Meses', 30, 149.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (4, 'Xbox Live Gold - 6 Meses', 50, 69.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (4, 'Xbox Live Gold - 3 Meses', 10, 29.00);

/*Centro*/
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (5, 'Doom Eternal - Xbox One', 100, 249.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (5, 'Call of Duty Modern Warfare', 150, 189.00);
INSERT INTO produto(codlocal, descricao, qte_estoque, preco_unitario) VALUES (5, 'Cyberpunk 2077', 0, 249.00);

/*Desconto*/

INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (1, 5, 10, 50);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (4, 20, 5, 100);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (7, 20, 10, 100);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (8, 20, 10, 100);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (9, 50, 10, 100);

INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (10, 10, 2, 100);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (11, 10, 2, 100);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (12, 10, 2, 100);

INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (13, 10, 3, 5);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (14, 10, 3, 5);
INSERT INTO desconto(codprod, percentual, qtd_min, qtd_max) VALUES (15, 10, 3, 5);




