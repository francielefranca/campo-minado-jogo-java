package campoMinado;

import java.util.Random;

public class Celula {
	
	private Random random = new Random();
	
	protected int[][] celulas;
	
	private boolean sorteio;
	
	private void sortearMinas(int quantidadeDeBombas, int linha, int coluna) {//sorteio aleatorio das minas
		int x, y;
		for(int i = 1; i <= quantidadeDeBombas; i++) {
			do {
				x = random.nextInt(linha) + 1;
				y = random.nextInt(coluna) + 1;
				if(this.celulas[x][y] == 1) {
					sorteio = true;
				} else {
					sorteio = false;
				}
			} while (sorteio);
			
			this.celulas[x][y] = 1;
		} 		
	}
	
	private void definirCelulas(int quantidadeDeBombas, int linha, int coluna) {//definicao das celulas com linhas e colunas 
		celulas = new int[linha + 2][coluna + 2];
		for (int i = 1; i <= linha; i++) {
			for (int j = 1; j <= coluna; j++) {
			}
		}
		sortearMinas(quantidadeDeBombas, linha, coluna);
	}
	
	public Celula() {
		definirCelulas(10, 9, 9);
	}
}
