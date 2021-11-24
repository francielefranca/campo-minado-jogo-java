package campoMinado;

import java.util.Random;

public class Celula {
	
	private Random random = new Random();
	
	protected int[][] celulas;
	
	private boolean sorteio;
	
	private void sortearMinas() {
		int x, y;
		for(int i = 1; i <= 40; i++) {
			do {
				x = random.nextInt(16) + 1;
				y = random.nextInt(16) + 1;
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
		celulas = new int[18][18];
		for (int i = 1; i <= 16; i++) {
			for (int j = 1; j <= 16; j++) {
			}
		}
		sortearMinas();
	}
	
	public Celula() {
		definirCelulas();
	}
}
