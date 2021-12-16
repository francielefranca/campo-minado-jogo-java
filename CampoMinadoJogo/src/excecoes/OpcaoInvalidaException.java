package excecoes;

@SuppressWarnings("serial")
public class OpcaoInvalidaException extends Exception {

	public OpcaoInvalidaException(String mensagem) { //excecao para opcao invalida no menu
		super(mensagem);
	}

}
