package campoMinado;

import java.util.Scanner;

public class Jogo {
	
	Scanner input = new Scanner(System.in);
	
	int x, y;
	char acao;
	
	boolean gameOver;
	
	Tabuleiro tabuleiro = new Tabuleiro();
	
	public void pontuacao() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] == 'A') {
			tabuleiro.pontos = tabuleiro.pontos + 100;
		}
	}
	
	public void casaAberta() {
		System.out.println("Casa já aberta.\n");
	}
	
	public void abrirCasa() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] == 'B') {
			System.out.println("Casa ocupada por bandeira!\n");
		} else {
			tabuleiro.tabuleiro[(-(x - 9))][y] = 'A';
			pontuacao();
			tabuleiro.marcarTabuleiro();
			System.out.println("");
		}
	}
	
	public void casa() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] == 'A') {
			casaAberta();
		} else { 
			if (tabuleiro.celulas[(-(x - 9))][y] == 7) {
				abrirCasa();
			}
		}
	}
	
	public void contadorDeBandeiras() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] == 'B') {
			--tabuleiro.quantidadeDeBandeiras;
			}
	}
	
	public void plantarBandeira() {
		tabuleiro.tabuleiro[(-(x - 9))][y] = 'B';
		contadorDeBandeiras();
		tabuleiro.marcarTabuleiro();
		System.out.println("");
	}
	
	public void removerBandeira() {
		tabuleiro.tabuleiro[(-(x - 9))][y] = '-';
		++tabuleiro.quantidadeDeBandeiras;
		tabuleiro.marcarTabuleiro();
		System.out.println("");
	}
	
	public void bandeira() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] != 'B') {
			plantarBandeira();
		} else {
			removerBandeira();
		}
		
		if (tabuleiro.quantidadeDeBandeiras < 1) {
			System.out.println("Suas bandeiras acabaram");
			acoes();
		}
	}
	
	public void acoes() {
		System.out.println("Você quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		acao = input.next().charAt(0);
		if (acao == 'a' || acao == 'A') {
			casa();
		} else if (acao == 'b' || acao == 'B') {
			bandeira();
			} else {
				acoes();
				}
		}
	
	public void receberCoordenadas() {
		System.out.print("Insira sua linha: ");
		x = input.nextInt();
		
		System.out.print("Insira sua coluna: ");
		y = input.nextInt();
		
		if (x > 8 || y > 8 || x < 1 || y < 1) {
			receberCoordenadas();
		}
	}
		
	public void fimDeJogo() {
		System.out.println("\n       Linhas\n");
		for (int i = 1; i < 9; i++) {
			System.out.print("       " + (-(i - 9)) + " ");
			for (int j = 1; j < 9; j++) {
				if (tabuleiro.celulas[i][j] == 0) {
					tabuleiro.tabuleiro[i][j] = 'X';
				}
				System.out.print("   " + tabuleiro.tabuleiro[i][j]);
			}
			System.out.println("");
		}
		System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("\n				  Colunas");
		
		System.out.println("");
		System.out.println("Havia uma mina, você perdeu.");
		System.out.println("Pontuação total: " + tabuleiro.pontos);
	}
	
	public void jogabilidade() {
		do {
			receberCoordenadas();
			acoes();
			if (tabuleiro.celulas[(-(x - 9))][y] == 0) {
				gameOver = true;
				fimDeJogo();
				}
		} while (!gameOver);
	}

	public Jogo() {
		jogabilidade();
	}	
}
