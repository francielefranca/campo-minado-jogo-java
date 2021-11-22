package campoMinado;

import java.util.Random;

public class Celula {
	
	Random random = new Random();
	
	int[][] celulas;
	
	int linha, coluna;
	
	int quantidadeDeBombas = 10;
	
	int quantidadeDeBandeiras = 10;
	
	boolean sorteio;
	
	int pontos = 0;
	
	private void sortearMinas() {
		int x, y;
		for(int i = 1; i <= 10; i++) {
			do {
				x = random.nextInt(9) + 1;
				y = random.nextInt(9) + 1;
				if(this.celulas[x][y] == 1) {
					sorteio = true;
				} else {
					sorteio = false;
				}
			} while (sorteio);
			
			this.celulas[x][y] = 1;
		} 		
	}
	
	private void definirCelulas() {
		celulas = new int[11][11];
			for (this.linha = 1; this.linha <= 9; this.linha++) {
				for (this.coluna = 1; this.coluna <= 9; this.coluna++) {
				}
			}
			sortearMinas();
	}
	
	public Celula() {
		definirCelulas();
	}
}
