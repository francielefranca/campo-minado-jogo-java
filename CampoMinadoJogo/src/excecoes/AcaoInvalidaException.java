package excecoes;

@SuppressWarnings("serial")
public class AcaoInvalidaException extends Exception {

	public AcaoInvalidaException(String mensagem) { //excecao para acoes invalidas no meio do jogo
		super(mensagem);
	}

}
