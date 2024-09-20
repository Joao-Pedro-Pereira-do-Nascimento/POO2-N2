package model;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author wallyson
 */
public class Agendamento {
    private static int contador = 0; // Elemento static
    private int idAgendamento;
    private Date dataHora;
    private Paciente paciente;
    private Medico medico;
    private StatusAgendamento status;

    public Agendamento(Date dataHora, Paciente paciente, Medico medico) {
        this.idAgendamento = ++contador; // Incrementa o contador para gerar um ID único
        this.dataHora = dataHora;
        this.paciente = paciente;
        this.medico = medico;
        this.status = StatusAgendamento.PENDENTE; // Status padrão
        JOptionPane.showMessageDialog(null, "Agendamento gerado. A consulta está a confirmar!");
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Agendamento.contador = contador;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public void cancelar() {
        this.status = StatusAgendamento.CANCELADO;
        JOptionPane.showMessageDialog(null, "Agendamento cancelado!");
    }

    public void confirmar() {
        this.status = StatusAgendamento.CONFIRMADO;
        JOptionPane.showMessageDialog(null, "Agendamento confimado!");
    }
}
