Para instalar o banco de dados, rode o script abaixo 
create database TrabalhoBD;


create table cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    genero ENUM('M', 'F') NOT NULL,
    altura VARCHAR(4) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);


create table fucionario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(15)
);

create table exercicio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
    /*agrupamento ENUM('pernas', 'bracos', 'peito', 'costas', 'abdomen', 'cardio') NOT NULL*/
);


create table Treino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    descricao TEXT
);

/*
create table TreinosClientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    treino_id INT NOT NULL,
    professor_id INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(id),
    FOREIGN KEY (treino_id) REFERENCES Treinos(id),
    FOREIGN KEY (professor_id) REFERENCES Professores(id)
)
*/

/*
create table Exercicio_treino (
    id INT AUTO_INCREMENT PRIMARY KEY,
    treino_id INT NOT NULL,
    exercicio_id INT NOT NULL,
    series INT,
    repeticoes INT,
    observacoes TEXT,
    FOREIGN KEY (treino_id) REFERENCES Treinos(id),
    FOREIGN KEY (exercicio_id) REFERENCES Exercicios(id)
);
*/

