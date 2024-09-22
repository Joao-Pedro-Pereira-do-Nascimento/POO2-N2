package model;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author wallyson
 */
public class Agendamento implements IAgendamento{
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

    @Override
    public int getIdAgendamento() {
        return idAgendamento;
    }

    @Override
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public Date getDataHora() {
        return dataHora;
    }

    @Override
    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public Medico getMedico() {
        return medico;
    }

    @Override
    public StatusAgendamento getStatus() {
        return status;
    }

    @Override
    public void cancelar() {
        this.status = StatusAgendamento.CANCELADO;
        JOptionPane.showMessageDialog(null, "Agendamento cancelado!");
    }

    @Override
    public void confirmar() {
        this.status = StatusAgendamento.CONFIRMADO;
        JOptionPane.showMessageDialog(null, "Agendamento confirmado!");
    }

    @Override
    public void informacoesAgendamento() {
        System.out.println("==================================================");
        System.out.println("========== [INFORMAÇÕES DO AGENDAMENTO] ==========");
        System.out.println("==================================================");
        System.out.println("Id do agendamento: " + idAgendamento);
        medico.exibirDados();
        paciente.exibirDados();
        System.out.println("Status do Agendamento: " + status);
        System.out.println("Data e hora: " + dataHora);
        System.out.println("==================================================\n");
    }
}
