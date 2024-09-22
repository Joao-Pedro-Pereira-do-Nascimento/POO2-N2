package model;

import java.util.Date;

/**
 *
 * @author wallyson
 */
public interface IAgendamento {
    int getIdAgendamento();
    Date getDataHora();
    Paciente getPaciente();
    Medico getMedico();
    StatusAgendamento getStatus();
    void setDataHora(Date dataHora);
    void setPaciente(Paciente paciente);
    void setMedico(Medico medico);
    void cancelar();
    void confirmar();
}
