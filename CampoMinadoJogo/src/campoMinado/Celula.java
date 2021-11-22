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
	
	boolean sorteio;
	
	public void sortearMinas() {
		int x, y;
		for(int i = 1; i <= this.quantidadeDeBombas; i++) {
			do {;
				x = random.nextInt(8) + 1;
				y = random.nextInt(8) + 1;
				if(this.celulas[x][y] == 1) {
					sorteio = true;
				} else {
					sorteio = false;
				}
			} while (sorteio);
			
			this.celulas[x][y] = 1;
		} 		
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
