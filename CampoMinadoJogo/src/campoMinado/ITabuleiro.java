package campoMinado;

public interface ITabuleiro {
	
	void gerarTabuleiro(int linha, int coluna);
	
	void tabuleiroEmJogo(boolean gameOver, int linha, int coluna);

}
