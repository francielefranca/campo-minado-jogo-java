package campoMinado;

import java.util.Scanner;

public class Jogo {
	
	Scanner input = new Scanner(System.in);
	
	int quantidadeDeBandeiras = 0;
	
	int x, y;
	char acao;
	
	boolean gameOver;
	
	Tabuleiro tabuleiro = new Tabuleiro();
	
	public void pontuacao() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] == 'A') {
			tabuleiro.pontos = tabuleiro.pontos + 10;
		}
	}
	
	public void contadorDeBandeiras() {
		if (tabuleiro.tabuleiro[(-(x - 9))][y] == 'B') {
			++quantidadeDeBandeiras;
			}
	}
	
	public void abrirCelula() {
		if (tabuleiro.celulas[(-(x - 9))][y] == 7) {
			tabuleiro.tabuleiro[(-(x - 9))][y] = 'A';
			pontuacao();
			tabuleiro.marcarTabuleiro();
			System.out.println("");
			}
	}
	
	public void plantarBandeira() {
		tabuleiro.tabuleiro[(-(x - 9))][y] = 'B';
		contadorDeBandeiras();
		if (quantidadeDeBandeiras > 10) {
			System.out.println("Suas bandeiras acabaram");
			acoes();
		}
		tabuleiro.marcarTabuleiro();
		System.out.println("");
	}
	
	public void acoes() {
		System.out.println("Você quer:\nAbrir a célula (A)\nPlantar uma bandeira (B)");
		acao = input.next().charAt(0);
		if (acao == 'a' || acao == 'A') {
			abrirCelula();
		}
		
		if (acao == 'b' || acao == 'B') {
			plantarBandeira();
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
	
	public void fim() {
		System.out.println("");
		for (int i = 1; i <= 8; i++) {
			System.out.print("            ");
			for (int j = 1; j <= 8; j++) {
				if (tabuleiro.celulas[i][j] == 0) {
					tabuleiro.tabuleiro[i][j] = 'X';
				}
				System.out.print(tabuleiro.tabuleiro[i][j] + "   ");
			}
			System.out.println("");
		}
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
				fim();
				}
		} while (!gameOver);
	}

	public Jogo() {
		jogabilidade();
	}	
}
