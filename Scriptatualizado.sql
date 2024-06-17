create table cliente (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL unique,
data_nascimento DATE NOT NULL,
genero ENUM('M', 'F','I') NOT NULL,
altura VARCHAR(4) NOT NULL,
telefone VARCHAR(15) NOT NULL );

CREATE TABLE funcionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(15)
);



create table exercicio (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
descricao TEXT, 
agrupamento ENUM('pernas', 'bracos', 'peito', 'costas', 'abdomen', 'cardio', 'ombros') NOT NULL);

create table treino (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(40) NOT NULL,
descricao TEXT );

create table TreinosClientes (
id INT AUTO_INCREMENT PRIMARY key,
cliente_id INT NOT NULL,
treino_id INT NOT NULL,
funcionario_id INT NOT NULL,
data_inicio DATE NOT NULL,
data_fim DATE,
FOREIGN KEY (cliente_id) REFERENCES cliente(id),
FOREIGN KEY (treino_id) REFERENCES treino(id),
FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
)

create table Exercicio_treino (
id INT AUTO_INCREMENT PRIMARY KEY,
treino_id INT NOT NULL,
exercicio_id INT NOT NULL,
series INT,
repeticoes INT,
observacoes TEXT,
FOREIGN KEY (treino_id) REFERENCES treino(id),
FOREIGN KEY (exercicio_id) REFERENCES exercicio(id) );

CREATE VIEW ClientesTreinos AS
SELECT 
    c.id AS cliente_id,
    c.nome AS cliente_nome,
    c.email AS cliente_email,
    t.id AS treino_id,
    t.nome AS treino_nome,
    t.descricao AS treino_descricao,
    f.id AS funcionario_id,
    f.nome AS funcionario_nome,
    f.email AS funcionario_email,
    tc.data_inicio,
    tc.data_fim
FROM 
    cliente c
JOIN 
    TreinosClientes tc ON c.id = tc.cliente_id
JOIN 
    treino t ON tc.treino_id = t.id
JOIN 
    funcionario f ON tc.funcionario_id = f.id;
   
   INSERT INTO cliente (nome, email, data_nascimento, genero, altura, telefone)
VALUES ('Luis Octavio', 'luis@gmail.com', '2004-03-30', 'M', '168', '44991679654');

   INSERT INTO cliente (nome, email, data_nascimento, genero, altura, telefone)
VALUES ('Mateus Ernesto', 'ernesto@gmail.com', '2003-05-28', 'M', '182', '44991658967');

   INSERT INTO funcionario (nome, email, telefone)
VALUES ('Rodrigo Pereira', 'rodrigo@nexus.com', '40028922');

   INSERT INTO funcionario (nome, email, telefone)
VALUES ('Fernando Batista', 'fernando@nexus.com', '40028923');

INSERT INTO exercicio (nome, descricao, agrupamento)
VALUES ('supino', 'Exercício para peito', 'peito');

INSERT INTO exercicio (nome, descricao, agrupamento)
VALUES ('leg press', 'Exercício para quadriceps', 'pernas');

INSERT INTO exercicio (nome, descricao, agrupamento)
VALUES ('rosca alternada', 'Exercício para biceps', 'bracos');

INSERT INTO exercicio (nome, descricao, agrupamento)
VALUES ('elevacao lateral', 'Exercício para ombros', 'ombros');

INSERT INTO treino (nome, descricao)
VALUES ('Treino A', 'Treino básico peito e triceps');

INSERT INTO treino (nome, descricao)
VALUES ('Treino B', 'Treino básico costas e biceps');

INSERT INTO treino (nome, descricao)
VALUES ('Treino C', 'Treino básico pernas e ombro');

INSERT INTO TreinosClientes (cliente_id, treino_id, funcionario_id, data_inicio, data_fim)
VALUES (1, 1, 1, '2024-06-04', '2024-07-04');


INSERT INTO TreinosClientes (cliente_id, treino_id, funcionario_id, data_inicio, data_fim)
VALUES (2, 2, 2, '2024-06-04', '2024-07-04');

select * from clientestreinos c 



