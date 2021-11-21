package campoMinado;

import java.util.Random;

public class Celula {
	
	Random random = new Random();
	
	int linha;
	int coluna;
	
	int[][] celulas;
	
	int numero;
	
	int quantidadeDeBombas = 0;
	
	int quantidadeDeBandeiras = 10;
	
	int pontos = 0;
	
	public void sortearMinas() {
		do {
			int x = random.nextInt(8) + 1;
			int y = random.nextInt(8) + 1;
			this.celulas[x][y] = 1;
			this.quantidadeDeBombas++;
		} while (this.quantidadeDeBombas < 10);
		
	}
	
	public void definirCelulas() {
		celulas = new int[10][10];
			for (this.linha = 1; this.linha < 9; this.linha++) {
				for (this.coluna = 1; this.coluna < 9; this.coluna++) {
				}
			}
			sortearMinas();
	}
	
	public Celula() {
		definirCelulas();
	}
}
