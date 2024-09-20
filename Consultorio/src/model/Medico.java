package model;

/**
 *
 * @author wallyson
 */
public class Medico extends Pessoa {
    private String crm;
    private int especialidade;

    public Medico(String nome, String sexo, String crm, int especialidade) {
        super(nome, sexo);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirDados() {
        System.out.println("Médico: " + getNome() + ", CRM: " + crm);
    }
}
