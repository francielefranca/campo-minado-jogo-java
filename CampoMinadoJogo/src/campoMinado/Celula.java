package campoMinado;

import java.util.Random;

public class Celula {
	
	Random random = new Random();
	
	int linha;
	int coluna;
	
	int[][] celulas;
	char[][] tabuleiro;
	
	int numero;
	
	int quantidadeDeBombas = 0;
	
	int quantidadeDeBandeiras = 10;
	
	int pontos = 0;
	
	public void sortearMinas() {
		int aleatorio = random.nextInt(8);
		if (aleatorio == 0 || aleatorio == 1) {
			numero = 0;
		} else {
			numero = 1;
			}
	}
	
	public void contadorDeBombas() {
		if (numero == 0) {
			++quantidadeDeBombas;
			} 
	}
	
	public void imprimirMinas() {
		
		celulas = new int[9][9];
		
		for (linha = 1; linha < 9; linha++) {
			for (coluna = 1; coluna < 9; coluna++) {
				if(quantidadeDeBombas < 10) {
					sortearMinas();
					contadorDeBombas();
				} else {
					numero = 1;
				}
				celulas[linha][coluna] = numero;
			}
		}
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/origin/main
