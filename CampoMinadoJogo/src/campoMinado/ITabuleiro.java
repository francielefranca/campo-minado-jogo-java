package campoMinado;

public interface ITabuleiro {
	
	void gerarTabuleiro(int linha, int coluna); //geracao do tabuleiro
	
	void tabuleiroEmJogo(boolean gameOver, int linha, int coluna); //tabuleiro na execucao do jogo

}
