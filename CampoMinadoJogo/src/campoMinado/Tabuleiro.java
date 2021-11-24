package campoMinado;

public class Tabuleiro {
		
	public Celula casas = new Celula();
	
	protected int linha, coluna;
	
	protected int quantidadeDeBombas = 40, quantidadeDeBandeiras = 40;
		
	protected void imprimirTabuleiro() {
		casas.celulas = new int[18][18];
		for (linha = 1; linha <= 16 ; linha++) {
			for (coluna = 1; coluna <= 16; coluna++) {
				casas.celulas[linha][coluna] = 9;
				System.out.print(casas.celulas[linha][coluna] + "   ");
				}
			System.out.println();
			}
		System.out.println();
		System.out.println("Bombas: " +quantidadeDeBombas);
		System.out.println("Bandeiras : " +quantidadeDeBandeiras);
		System.out.println();
	}
		
	protected void marcarTabuleiro(boolean gameOver) {
		if(gameOver == false) {
			for (linha = 1; linha <= 16; linha++) {
				for (coluna= 1; coluna <= 16; coluna++) {
					System.out.print(casas.celulas[linha][coluna] + "   ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Bombas: " +quantidadeDeBombas);
			System.out.println("Bandeiras : " +quantidadeDeBandeiras);
		}
	}
		
	public Tabuleiro() {
		imprimirTabuleiro();
	}
}
