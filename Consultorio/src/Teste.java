
import java.util.Date;
import model.Agendamento;
import dao.MedicoDAO;
import model.Medico;
import model.Paciente;
import service.AgendamentoService;
import database.DatabaseConnection;
import java.sql.Connection;
import java.util.List;


/**
 * 
 * @author wallyson
 */
public class Teste {
    public static void main(String[] args) {
        Paciente p = new Paciente("Maria", "F", "1997/02/03", "111333236", "maria@gmail.com");
        Medico medico = new Medico("Dr. Pimenta", "M", "CRM", 1);
        
        Agendamento agendamento = new Agendamento(new Date("2024/03/10 10:30:00"), p, medico);
        agendamento.confirmar();
        System.out.println("Dados do agendamento");
        System.out.println(agendamento.getMedico().getNome());
        System.out.println("Data: " + agendamento.getDataHora());
        agendamento.cancelar();
        
        
        /*Medico medico2 = new Medico("Dr. João", "M", "CRM1234", 1);
        Paciente paciente = new Paciente("Maria", "F", "1990-05-20", "123456789", "maria@email.com");

        AgendamentoService agendamentoService = new AgendamentoService();
        agendamentoService.agendar(paciente, medico2, new Date());
        System.out.println(new Date());

        medico2.exibirDados();
        paciente.exibirDados();*/
        
        /*try (Connection conn = DatabaseConnection.getConnection()) {
            MedicoDAO medicoDAO = new MedicoDAO(conn);
            
            // Criar um novo médico
            //Medico medico3 = new Medico("Dr. Silva", "M", "CRM123456", 1);
            //medicoDAO.create(medico3);
            
            // Ler todos os médicos
            List<Medico> medicos = medicoDAO.read();
            for (Medico m : medicos) {
                m.exibirDados();
            }
            
            // Encontra um médico pelo CRM
            Medico medicoEncontrado = medicoDAO.informacoesMedico("CRM123456");
            if (medicoEncontrado != null) {
                medicoEncontrado.exibirDados();
            } else {
                System.out.println("Médico não encontrado.");
            }

            // Atualizar um médico
            //medico3.setNome("Dr. Silva Atualizado");
            //medicoDAO.update(medico3);

            // Deletar um médico
            //medicoDAO.delete("CRM123456");
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
