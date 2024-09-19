-- Criação do banco de dados
CREATE DATABASE ConsultorioMedico;
USE ConsultorioMedico;

-- Tabela Especialidade
CREATE TABLE Especialidade (
    IdEspecialidade INT AUTO_INCREMENT PRIMARY KEY,
    NomeEspecialidade VARCHAR(100) NOT NULL
);

-- Tabela Medico
CREATE TABLE Medico (
    IdMedico INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    CRM VARCHAR(20) NOT NULL UNIQUE,
    sexo ENUM('F', 'M', 'não informado') NOT NULL DEFAULT 'não informado',
    fk_IdEspecialidade INT,
    FOREIGN KEY (fk_IdEspecialidade) REFERENCES Especialidade(IdEspecialidade)
);

-- Tabela Paciente
CREATE TABLE Paciente (
    IdPaciente INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    sexo ENUM('F', 'M', 'não informado') NOT NULL DEFAULT 'não informado',
    DataNascimento DATE NOT NULL,
    Telefone VARCHAR(20),
    Email VARCHAR(100) UNIQUE
);

-- Tabela Agendamento
CREATE TABLE Agendamento (
    IdAgendamento INT AUTO_INCREMENT PRIMARY KEY,
    DataHora DATETIME NOT NULL,
    fk_IdPaciente INT,
    fk_IdMedico INT,
    Status ENUM('Confirmado', 'Cancelado', 'Pendente') NOT NULL DEFAULT 'Pendente',
    FOREIGN KEY (fk_IdPaciente) REFERENCES Paciente(IdPaciente),
    FOREIGN KEY (fk_IdMedico) REFERENCES Medico(IdMedico),
    CONSTRAINT UNQ_Medico_DataHora UNIQUE (fk_IdMedico, DataHora), -- Um médico não pode atender múltiplos pacientes na mesma data e hora
    CONSTRAINT UNQ_Paciente_DataHora UNIQUE (fk_IdPaciente, DataHora) -- Um paciente não pode ser atendido por múltiplos médicos na mesma data e hora
);

-- Tabela Consulta
CREATE TABLE Consulta (
    IdConsulta INT AUTO_INCREMENT PRIMARY KEY,
    DataHora DATETIME NOT NULL,
    fk_IdAgendamento INT UNIQUE, -- Relação 1:1 com Agendamento
    Descricao TEXT,
    FOREIGN KEY (fk_IdAgendamento) REFERENCES Agendamento(IdAgendamento)
    ON DELETE CASCADE -- Deletar a consulta se o agendamento for deletado
);

-- Tabela Prescricao
CREATE TABLE Prescricao (
    IdPrescricao INT AUTO_INCREMENT PRIMARY KEY,
    DataEmissao DATE NOT NULL,
    fk_IdConsulta INT UNIQUE, -- Relação 1:1 com Consulta
    Medicamento VARCHAR(50) NOT NULL,
    Dosagem VARCHAR(50) NOT NULL,
    FOREIGN KEY (fk_IdConsulta) REFERENCES Consulta(IdConsulta)
    ON DELETE CASCADE -- Deletar a prescrição se a consulta for deletada
);
