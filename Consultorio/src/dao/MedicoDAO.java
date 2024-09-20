package dao;

import model.Medico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wallyson
 */
public class MedicoDAO {
    private Connection connection;

    // Construtor que inicializa a conexão
    public MedicoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um médico
    public void create(Medico medico) throws SQLException {
        String sql = "INSERT INTO Medico (Nome, CRM, sexo, fk_IdEspecialidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medico.getNome());
            statement.setString(2, medico.getCrm());
            statement.setString(3, medico.getSexo());
            statement.setInt(4, medico.getEspecialidade());
            statement.executeUpdate();
        }
    }

    // Método para listar todos os médicos
    public List<Medico> read() throws SQLException {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Medico";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Medico medico = new Medico(
                        resultSet.getString("Nome"),
                        resultSet.getString("sexo"),
                        resultSet.getString("CRM"),
                        resultSet.getInt("fk_IdEspecialidade")
                );
                medicos.add(medico);
            }
        }
        return medicos;
    }
    
    // Método para ler um médico pelo CRM
    public Medico informacoesMedico(String crm) throws SQLException {
        String sql = "SELECT * FROM Medico WHERE CRM = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, crm);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Medico(
                            resultSet.getString("Nome"),
                            resultSet.getString("sexo"),
                            resultSet.getString("CRM"),
                            resultSet.getInt("fk_IdEspecialidade")
                    );
                }
            }
        }
        return null; // Retorna null se o médico não for encontrado
    }

    // Método para atualizar um médico
    public void update(Medico medico) throws SQLException {
        String sql = "UPDATE Medico SET Nome = ?, sexo = ?, fk_IdEspecialidade = ? WHERE CRM = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, medico.getNome());
            statement.setString(2, medico.getSexo());
            statement.setInt(3, medico.getEspecialidade());
            statement.setString(4, medico.getCrm());
            statement.executeUpdate();
        }
    }

    // Método para deletar um médico
    public void delete(String crm) throws SQLException {
        String sql = "DELETE FROM Medico WHERE CRM = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, crm);
            statement.executeUpdate();
        }
    }

}
