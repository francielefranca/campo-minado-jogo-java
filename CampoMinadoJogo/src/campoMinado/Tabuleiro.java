package campoMinado;

public class Tabuleiro {
	
	Celula casas = new Celula();
	
	public void imprimirTabuleiro() {
		casas.celulas = new int[10][10];
		for (casas.linha = 1; casas.linha < 9; casas.linha++) {
			for (casas.coluna = 1; casas.coluna < 9; casas.coluna++) {
				casas.celulas[casas.linha][casas.coluna] = 9;
				System.out.print(casas.celulas[casas.linha][casas.coluna] + "   ");
				}
			System.out.println();
			}
		System.out.println();
		System.out.println("Bombas: " +casas.quantidadeDeBombas);
		System.out.println("Pontos: " +casas.pontos);
		System.out.println("Bandeiras : " +casas.quantidadeDeBandeiras);
		System.out.println();
	}
	
	public void marcarTabuleiro(boolean gameOver) {
		if(gameOver == false) {
			for (casas.linha = 1; casas.linha < 9; casas.linha++) {
			for (casas.coluna = 1; casas.coluna < 9; casas.coluna++) {
				System.out.print(casas.celulas[casas.linha][casas.coluna] + "   ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Bombas: " +casas.quantidadeDeBombas);
			System.out.println("Pontos: " +casas.pontos);
			System.out.println("Bandeiras : " +casas.quantidadeDeBandeiras);
			System.out.println();
		}
	}
	
	public Tabuleiro() {
		imprimirTabuleiro();
	}
}
