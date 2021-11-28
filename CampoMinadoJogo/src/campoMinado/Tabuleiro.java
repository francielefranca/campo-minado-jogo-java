package campoMinado;

public class Tabuleiro {
	
	public Celula casas;
	
	protected int linha, coluna;
	
	protected int quantidadeDeBombas, quantidadeDeBandeiras;
		
	protected void imprimirTabuleiro(int linha, int coluna, int quantidadeDeBombas, int quantidadeDeBandeiras) { //impressão na tela do tabuleiro de células
		this.linha = linha;
		this.coluna = coluna;
		this.quantidadeDeBombas = quantidadeDeBombas;
		this.quantidadeDeBandeiras = quantidadeDeBandeiras;
		for (int i = 1; i <= this.linha; i++) {
			for (int j = 1; j <= this.coluna; j++) {
				casas.celulas[i][j] = '-';
				System.out.print(casas.celulas[i][j] + "   ");
				}
			System.out.println();
			}
		System.out.println();
		System.out.println("Bombas: " +quantidadeDeBombas);
		System.out.println("Bandeiras : " +quantidadeDeBandeiras);
		System.out.println();
	}
		
	protected void imprimirTabuleiro(boolean gameOver) { //marcação no tabuleiro e informações durante o jogo
		if(!gameOver) {
			for (int i = 1; i <= this.linha ; i++) {
				for (int j= 1; j <= this.coluna; j++) {
					System.out.print(casas.celulas[i][j] + "   ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Bombas: " +quantidadeDeBombas);
			System.out.println("Bandeiras : " +quantidadeDeBandeiras);
		}
	}
		
	public Tabuleiro() {
		casas = new Celula();
		imprimirTabuleiro(9, 9, 10, 10);
	}
}
