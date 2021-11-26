package campoMinado;

public class Tabuleiro {
	
	public Celula casas;
	
	protected int linha, coluna;
	
	protected int quantidadeDeBombas, quantidadeDeBandeiras;
		
	protected void imprimirTabuleiro(int linha, int coluna, int quantidadeDeBombas, int quantidadeDeBandeiras) {//impressao na tela do tabuleiro de celulas
		this.linha = linha;
		this.coluna = coluna;
		this.quantidadeDeBombas = quantidadeDeBombas;
		this.quantidadeDeBandeiras = quantidadeDeBandeiras;
		for (int i = 1; i <= this.linha; i++) {
			for (int j = 1; j <= this.coluna; j++) {
				casas.celulas[i][j] = 9;
				System.out.print(casas.celulas[i][j] + "   ");
				}
			System.out.println();
			}
		System.out.println();
		System.out.println("Bombas: " +quantidadeDeBombas);
		System.out.println("Bandeiras : " +quantidadeDeBandeiras);
		System.out.println();
	}
		
	protected void marcarTabuleiro(boolean gameOver) {//marcacao no tabuleiro e informacoes durante o jogo
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
