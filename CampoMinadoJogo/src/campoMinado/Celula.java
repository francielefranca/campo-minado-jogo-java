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
	
	public void gerarCasasVizinhas() {
        for (int linha = 0; linha < 8 ; linha++) {
        	for (int coluna = 0;  coluna < 8; coluna++){
        		for (int i = 0; i <= 1; i++) {
        			for (int j = 0; j <= 1; j++) {
        				if (celulas[linha][coluna] != 0) {
        					if(celulas[linha + i][coluna + j] == 0) {
        						celulas[linha][coluna]++;
        						}
        					}
        			}                
        		}
        	}            
        }
    }
	
	public void abrirVizinhas() {
		
    }

	
	public void sortearMinas() {
		int aleatorio = random.nextInt(8);
		if (aleatorio == 0 || aleatorio == 1) {
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
