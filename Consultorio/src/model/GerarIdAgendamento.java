package model;

/**
 *
 * @author wallyson
 */
public class GerarIdAgendamento {
    static int contador = 0;
    
    static int gerarId() {
        return ++contador;  // Incrementa o contador para gerar o ID
    }
    
    static int getContador() {
        return contador;
    }
}
