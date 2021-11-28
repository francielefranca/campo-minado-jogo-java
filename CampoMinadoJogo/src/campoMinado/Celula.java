package campoMinado;

import java.util.Random;

public class Celula {
	
	private Random random = new Random();
	
	protected char[][] celulas;
	
	private boolean sorteio;
	
	private void sortearMinas(int quantidadeDeBombas, int linha, int coluna) { //sorteio aleatório das minas
		int x, y;
		for(int i = 1; i <= quantidadeDeBombas; i++) {
			do {
				x = random.nextInt(linha) + 1;
				y = random.nextInt(coluna) + 1;
				if(this.celulas[x][y] == 'M') {
					sorteio = true;
				} else {
					sorteio = false;
				}
			} while (sorteio);
			
			this.celulas[x][y] = 'M';
		} 		
	}
	
	private void definirCelulas(int quantidadeDeBombas, int linha, int coluna) { //posicionamento das células
		celulas = new char[linha + 2][coluna + 2];
		for (int i = 1; i <= linha; i++) {
			for (int j = 1; j <= coluna; j++) {
				celulas[i][j] = '_';
			}
		}
		sortearMinas(quantidadeDeBombas, linha, coluna);
	}
	
	public Celula() {
		definirCelulas(10, 9, 9);
	}
}
