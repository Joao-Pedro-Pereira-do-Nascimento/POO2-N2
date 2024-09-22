package model;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author wallyson
 */
public class Agendamento{
    private static int contador = 0; // Elemento static
    private int idAgendamento;
    private Date dataHora;
    private Paciente paciente;
    private Medico medico;
    private StatusAgendamento status;

    public Agendamento(Date dataHora, Paciente paciente, Medico medico) {
        this.idAgendamento = ++contador; // Incrementa o contador para gerar o ID
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.medico = medico;
        this.status = StatusAgendamento.PENDENTE; // Status padrão
        JOptionPane.showMessageDialog(null, "Agendamento gerado. A consulta está a confirmar!");
    }

    static int getContador() {
        return contador;
    }

    static void setContador(int contador) {
        Agendamento.contador = contador;
    }
}
