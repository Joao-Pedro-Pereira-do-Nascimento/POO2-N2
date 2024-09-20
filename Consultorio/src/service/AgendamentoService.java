package service;

import model.Agendamento;
import model.Medico;
import model.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wallyson
 */
public class AgendamentoService {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public void agendar(Paciente paciente, Medico medico, Date dataHora) {
        Agendamento agendamento = new Agendamento(dataHora, paciente, medico);
        agendamentos.add(agendamento);
        System.out.println("Agendamento realizado com sucesso!");
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentos;
    }
}
