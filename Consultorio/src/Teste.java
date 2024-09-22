
import java.util.Date;
import model.Agendamento;
import model.Medico;
import model.Paciente;

/**
 *
 * @author wallyson
 */
public class Teste {
    public static void main(String[] args) {
        Medico m = new Medico("Dr. Pimenta", "M", "CRM984567", 1);
        Paciente p = new Paciente("Maria", "F", "1555/02/23", "1123654897", "maria@gamil.com");
        
        Agendamento a = new Agendamento(new Date("2024/11/11 10:25"), p, m);
        
        a.informacoesAgendamento();
        a.confirmar();
        a.informacoesAgendamento();
        
    }
}
