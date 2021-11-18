package campoMinado;

public class Tabuleiro {
	
	Celula contadores = new Celula();
	
	char[][] tabuleiro;
	
	int x, y;
	
	public void imprimirTabuleiro() {
		
		tabuleiro = new char[9][9];
		
		System.out.println("\n       Linhas\n");
		for (this.x = 1; this.x < 9; this.x++) {
			System.out.print("       " + (-(this.x - 9)) + " ");
			for (this.y = 1; this.y < 9; this.y++) {
				tabuleiro[x][y] = '-';
				System.out.print("   "+ tabuleiro[this.x][this.y]);
			}
			System.out.println("");
		}
		System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("\n				  Colunas");
        
		System.out.println("");
		System.out.println("Bombas: " + 10);
		System.out.println("Pontos: " + 0);
		System.out.println("Bandeiras : " + 10);
		System.out.println("");
	}
	
	public void marcarTabuleiro() {
		System.out.println("\n       Linhas\n");
		for (this.x = 1; this.x < 9; this.x++) {
			System.out.print("       " + (-(this.x - 9)) + " ");
			for (this.y = 1; this.y < 9; this.y++) {
				System.out.print("   " + tabuleiro[this.x][this.y]);
			}
			System.out.println("");
		}
		System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("\n				  Colunas");
        
		System.out.println("");
		System.out.println("Bombas: " + contadores.quantidadeDeBombas);
		System.out.println("Pontos: " + contadores.pontos);
		System.out.println("Bandeiras : " + contadores.quantidadeDeBandeiras);
		System.out.println("");
	}
	
	public Tabuleiro() {
		imprimirTabuleiro();
	}
}
