package application;

import dao.MedicoDAO;
import database.DatabaseConnection;
import exceptions.CampoVazioException;
import exceptions.MedicoNaoEncontradoException;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import service.AgendamentoService;

/**
 *
 * @author wallyson
 */
public class Consultorio {
    public Consultorio() throws MedicoNaoEncontradoException {
        
        Scanner sc = new Scanner(System.in);
        
        try (Connection connection = DatabaseConnection.getConnection()) {
            MedicoDAO medicoDAO = new MedicoDAO(connection);

            while (true) {
                System.out.println("\n========================================");
                System.out.println("----------------| Menu |----------------");
                System.out.println("========================================");
                System.out.println("[1] Cadastrar Paciente");
                System.out.println("[2] Cadastrar Médico");
                System.out.println("[3] Listar Médicos");
                System.out.println("[4] Consultar Médico por CRM");
                System.out.println("[5] Excluir Médico por CRM");
                System.out.println("[0] Sair");
                System.out.println("=========================================\n");
                
                int opcao = sc.nextInt();
                sc.nextLine();
                
                switch (opcao) {
                    case 1:
                        
                        try {
                            
                            Paciente paciente;
                            
                            System.out.println("[CADASTRANDO PACIENTE]");
                            
                            System.out.print("Nome:* ");
                            String nomePaciente = sc.nextLine();
                            if (nomePaciente.trim().isEmpty()) {
                                throw new CampoVazioException("Nome do paciente não pode estar vazio.");                            
                            }
                            
                            System.out.print("Sexo:* ");
                            String sexo = sc.nextLine().toUpperCase();
                            if (sexo.trim().isEmpty()) {
                                throw new CampoVazioException("O sexo do paciente precisa ser informado!");
                            }
                            
                            System.out.print("Data de nascimento: ano/mês/dia ");
                            String dataNasc = sc.nextLine();
                            if (dataNasc.trim().isEmpty()) {
                                throw new CampoVazioException("Data de nascimento não pode estar vazia.");
                            }
                            
                            System.out.print("Telefone :");
                            String telefone = sc.nextLine();
                            System.out.print("Email: ");
                            String email = sc.nextLine();
                        
                            if (telefone.trim().isEmpty() && email.trim().isEmpty()) {
                                paciente = new Paciente(nomePaciente, sexo, dataNasc);
                            } else if (!telefone.trim().isEmpty() && email.trim().isEmpty()) {
                                paciente = new Paciente(nomePaciente, sexo, dataNasc, telefone);
                            } else {
                                paciente = new Paciente(nomePaciente, sexo, dataNasc, telefone, email);
                            }
                            
                            System.out.println("Cadastro realizado com sucesso!\n");
                            
                            System.out.print("Gostaria de agendar uma consulta? [S/N]");
                            char resposta = sc.nextLine().toUpperCase().charAt(0);
                            
                            if (resposta == 'S') {
                                Medico medico2 = new Medico("Dr. João", "M", "CRM1234", 1);
                                AgendamentoService agendamento = new AgendamentoService();
                                agendamento.agendar(paciente, medico2, new Date());
                                
                                agendamento.confirmarAgendamento();
                                
                            }
                            
                            
                        } catch (CampoVazioException e) {
                            JOptionPane.showMessageDialog(null, "Campos marcados com (*) são obrigatórios!");
                            System.out.println(e.getMessage());
                        }
                        
                        break;
                        
                    case 2:
                        Medico medico3;
                        
                        System.out.println("[CADASTRANDO MÉDICO]");
                        System.out.print("Nome:* ");
                        String nomeMedico = sc.nextLine();
                        System.out.print("Sexo:* ");
                        String sexo = sc.nextLine();
                        System.out.print("CRM:* ");
                        String crm = sc.nextLine();
                        System.out.println("Especialidade:* ");
                        System.out.println("[1] Cardiologia");
                        System.out.println("[2] Pediatria");
                        System.out.println("[3] Dermatologia");
                        System.out.println("[4] Ortopedia");
                        int fkEspecialidade= sc.nextInt();
                        sc.nextLine();
                        
                        medico3 = new Medico(nomeMedico, sexo, crm, fkEspecialidade);
                        
                        medicoDAO.create(medico3);
                        medico3.exibirDados();
                        
                        System.out.print("Quer corrigir alguma informação? [S/N] ");
                        String resposta = sc.nextLine();
                        if (resposta.toUpperCase().equals("S")) {
                            System.out.println("[ATUALIZANDO MÉDICO]");
                            System.out.print("Nome:* ");
                            nomeMedico = sc.nextLine();
                            System.out.print("Sexo:* ");
                            sexo = sc.nextLine();
                            System.out.println("Especialidade:* ");
                            System.out.println("[1] Cardiologia");
                            System.out.println("[2] Pediatria");
                            System.out.println("[3] Dermatologia");
                            System.out.println("[4] Ortopedia");
                            fkEspecialidade = sc.nextInt();
                            sc.nextLine();

                            medico3.setNome(nomeMedico);
                            medico3.setSexo(sexo);
                            medico3.setEspecialidade(fkEspecialidade);
                            
                            medicoDAO.update(medico3);
                            medico3.exibirDados();
                        }
                        break;

                    case 3:
                        System.out.println("[MÉDICOS CADASTRADOS NO SISTEMA]");
                        List<Medico> medicos = medicoDAO.read();
                        for (Medico m : medicos) {
                            m.exibirDados();
                        }
                        break;
                    case 4:
                        System.out.println("[INFORMAÇÕES DE UM ÚNICO MÉDICO]");
                        System.out.println("Qual o CRM do médicoo? ");
                        crm = sc.nextLine();
                        Medico medicoEncontrado = medicoDAO.informacoesMedico(crm);
                        if (medicoEncontrado != null) {
                            medicoEncontrado.exibirDados();
                        } else {
                            throw new MedicoNaoEncontradoException("Médico não encontrado. Verifique o CRM e digite novamente!");
                        }
                        break;
                        
                    case 5:
                        System.out.println("[DELETANDO MÉDICO]");
                        System.out.print("Qual o CRM do médico que deseja deletar? ");
                        String crM = sc.nextLine();
                        medicoDAO.delete(crM);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        return;
                        
                    default:
                        System.out.println("ok");
                        break;
                }
                
            }
            
        } catch (SQLException e) {
            System.out.println("Erro de conexão ao banco de dados: " + e.getMessage());
        }
        
        sc.close();
    }
}
