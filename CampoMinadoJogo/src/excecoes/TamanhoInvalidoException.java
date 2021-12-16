package excecoes;

@SuppressWarnings("serial")
public class TamanhoInvalidoException extends Exception {

	public TamanhoInvalidoException(String mensagem) { //excecao para tamanho invalido de linha ou coluna entradas pelo jogador
		super(mensagem);
	}

}
