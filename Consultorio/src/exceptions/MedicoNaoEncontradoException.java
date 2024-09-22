package exceptions;

/**
 *
 * @author wallyson
 */
public class MedicoNaoEncontradoException extends Exception {
    public  MedicoNaoEncontradoException(String mensagemDeErro) {
		super(mensagemDeErro);
	}
}
