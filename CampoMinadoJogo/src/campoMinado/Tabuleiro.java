package campoMinado;

import celula.*;

public class Tabuleiro {
	
	protected Celula[][] tabuleiro;
	
	public Tabuleiro(int linha, int coluna) {
		tabuleiro = new Celula[linha][coluna];
		gerarTabuleiro(linha, coluna);
	}
		
	protected void gerarTabuleiro(int linha, int coluna) { 
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				tabuleiro[i][j] = new CelulaVazia();
			}
		}
	}
	
	protected void tabuleiroEmJogo(boolean gameOver, int linha, int coluna) {
		if(!gameOver) {
			for(int i = 0; i < linha; i++) {
				for(int j = 0; j < coluna; j++) {
					System.out.print(tabuleiro[i][j] + "   ");
				}
				System.out.println();
			}
		}
	}
}
