
import application.Consultorio;
import exceptions.MedicoNaoEncontradoException;
import java.util.Date;
import model.Agendamento;
import model.Medico;
import model.Paciente;
import service.AgendamentoService;

/**
 *
 * @author wallyson
 */
public class Teste {
    public static void main(String[] args) throws MedicoNaoEncontradoException {
        Medico m = new Medico("Dr. Pimenta", "M", "CRM984567", 1);
        Paciente p = new Paciente("Maria", "F", "1555/02/23", "1123654897", "maria@gamil.com");
        
        AgendamentoService agendamento = new AgendamentoService();
        
        agendamento.agendar(p, m, new Date());
        agendamento.confirmarAgendamento();
        
        Consultorio consultorio = new Consultorio();
 
    }
}
