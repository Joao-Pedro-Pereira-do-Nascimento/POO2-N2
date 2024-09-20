package model;

/**
 *
 * @author wallyson
 */
public class Paciente extends Pessoa {
    private String dataNascimento;
    private String telefone;
    private String email;

    public Paciente(String nome, String sexo, String dataNascimento, String telefone, String email) {
        super(nome, sexo);
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void exibirDados() {
        System.out.println("Paciente: " + getNome() + ", Data de Nascimento: " + dataNascimento);
    }
}
