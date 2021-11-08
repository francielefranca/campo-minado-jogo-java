package campoMinado;

import java.util.Random;

public class Celula {
	
	Random random = new Random();
	
	int linha;
	int coluna;
	
	int[][] celulas;
	
	int numero;
	
	int quantidadeDeBombas = 0;
	
	int pontos = 0;
	
	public void sortearMinas() {
		int aleatorio = random.nextInt(8);
		if (aleatorio == 0 || aleatorio == 2) {
			numero = 0;
		} else {
			numero = 7;
			}
	}
	
	public void contadorDeBombas() {
		if (numero == 0) {
			++quantidadeDeBombas;
			} 
	}
	
	public void imprimirMinas() {
		
		celulas = new int[9][9];
		
		for (linha = 1; linha <= 8; linha++) {
			for (coluna = 1; coluna <= 8; coluna++) {
				if(quantidadeDeBombas < 10) {
					sortearMinas();
					contadorDeBombas();
				} else {
					numero = 7;
				}
				celulas[linha][coluna] = numero;
			}
		}
	}
}
