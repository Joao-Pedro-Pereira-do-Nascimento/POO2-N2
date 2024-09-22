package service;

import model.Agendamento;
import model.Medico;
import model.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wallyson
 */
public class AgendamentoService {
    private List<Agendamento> agendamentos = new ArrayList<>();
    private Agendamento agendamento;

    public void agendar(Paciente paciente, Medico medico, Date dataHora) {
        agendamento = new Agendamento(dataHora, paciente, medico);
        agendamentos.add(agendamento);
        System.out.println("Agendamento realizado com sucesso!");
    }
    
    public void confirmarAgendamento() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Sobre o agendamento");
        System.out.println("[1] CONFIRMAR");
        System.out.println("[2] CANCELAR");
        System.out.print(":");
        int op = sc.nextInt();
        if (op == 1) {
            agendamento.confirmar();
        } else {
            agendamento.cancelar();
        }
        agendamento.informacoesAgendamento();
        
        //sc.close();
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentos;
    }
}
