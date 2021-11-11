package campoMinado;

public class Tabuleiro extends Celula {
	
	public void imprimirTabuleiro() {
		
		tabuleiro = new char[9][9];
		
		System.out.println("\n       Linhas\n");
		for (linha = 1; linha < 9; linha++) {
			System.out.print("       " + (-(linha - 9)) + " ");
			for (coluna = 1; coluna < 9; coluna++) {
				tabuleiro[linha][coluna] = '-';
				System.out.print("   "+ tabuleiro[linha][coluna]);
			}
			System.out.println("");
		}
		System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("\n				  Colunas");
        
		System.out.println("");
		System.out.println("Bombas: " + quantidadeDeBombas);
		System.out.println("Pontos: " + pontos);
		System.out.println("Bandeiras : " + quantidadeDeBandeiras);
		System.out.println("");
	}
	
	public void marcarTabuleiro() {
		System.out.println("\n       Linhas\n");
		for (linha = 1; linha < 9; linha++) {
			System.out.print("       " + (-(linha - 9)) + " ");
			for (coluna = 1; coluna < 9; coluna++) {
				System.out.print("   " + tabuleiro[linha][coluna]);
			}
			System.out.println("");
		}
		System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("\n				  Colunas");
        
		System.out.println("");
		System.out.println("Bombas: " + quantidadeDeBombas);
		System.out.println("Pontos: " + pontos);
		System.out.println("Bandeiras : " + quantidadeDeBandeiras);
		System.out.println("");
	}
	
	public Tabuleiro() {
		imprimirMinas();
		imprimirTabuleiro();
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/origin/main
