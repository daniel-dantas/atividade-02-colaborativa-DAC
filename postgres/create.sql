CREATE TABLE clientes(
    nome VARCHAR(50),
    CPF VARCHAR(15),
    id serial,
    PRIMARY KEY (id)
);

CREATE TABLE produtos(
    descricao VARCHAR(100),
    valor NUMERIC,
    id SERIAL,
    PRIMARY KEY (id)
);

CREATE TABLE Vendas(
    total FLOAT,
    id_cliente int,
    id SERIAL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE RESTRICT
);


CREATE TABLE item(
    quantidade int,
    id_produto int,
    id_venda int,
    FOREIGN KEY (id_produto) REFERENCES produto(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_venda) REFERENCES venda(id) ON DELETE RESTRICT,
    PRIMARY KEY(id_venda,id_produto)
)

INSERT INTO clientes (descricao, valor) VALUES ('Teclado','15');
INSERT INTO clientes (descricao, valor) VALUES ('Monitor','450');
INSERT INTO clientes (descricao, valor) VALUES ('Mouse','35');
INSERT INTO clientes (descricao, valor) VALUES ('Teclado Gamer','50');


INSERT INTO clientes (nome, cpf) VALUES ('Kiko','123');
INSERT INTO clientes (nome, cpf) VALUES ('Chaves','124');
INSERT INTO clientes (nome, cpf) VALUES ('Madruga','125');
INSERT INTO clientes (nome, cpf) VALUES ('Florinda','126');
