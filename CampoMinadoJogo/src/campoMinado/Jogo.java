package campoMinado;

import java.util.Scanner;
<<<<<<< HEAD
import java.time.Instant;
//import java.time.Duration;
/*import java.time.LocalDate;
import java.time.format.DateTimeFormatter;*/

//import's para o tempo
=======
>>>>>>> refs/remotes/origin/main

public class Jogo {
<<<<<<< HEAD
=======
	
	Scanner input = new Scanner(System.in);
	
	int w, y;
	int x;
	
	char acao;
	int bombasVizinhas;
	
	boolean gameOver;
	
	Tabuleiro tabuleiro = new Tabuleiro();
	
	public void conferirVizinhas() {
		bombasVizinhas = 0;
>>>>>>> refs/remotes/origin/main
		
<<<<<<< HEAD
	int w, y;
	int x;
	
	int bombasVizinhas;
	
	char acao;
	
	boolean gameOver;
	
	boolean temBomba = false;
	
	Scanner input = new Scanner(System.in);

	Tabuleiro tabuleiro = new Tabuleiro();
	//InteracaoComJogador interacaoComJogador = new InteracaoComJogador();
	
	Instant start = Instant.now();//contagem de tempo
	
	public void conferirVizinhas() {
		bombasVizinhas = 0;
		
		if ((x - 1) > 0 && tabuleiro.celulas[x - 1][y] == 0) {
			++bombasVizinhas;
			}
		if ((x + 1) < 9 && tabuleiro.celulas[x + 1][y] == 0) {
			++bombasVizinhas;
			} 
		if ((y + 1) < 9 && tabuleiro.celulas[x][y + 1] == 0) {
			++bombasVizinhas;
			} 
		if ((y - 1) > 0 && tabuleiro.celulas[x][y - 1] == 0) {
			++bombasVizinhas;
			} 
		if (((x + 1) < 9 && (y + 1) < 9) && tabuleiro.celulas[x + 1][y + 1] == 0) {
			++bombasVizinhas;
			} 
		if (((x - 1) > 0 && (y - 1) > 0) && tabuleiro.celulas[x - 1][y - 1] == 0) {
			++bombasVizinhas;
			}
		if (((x + 1) < 9 && (y - 1) > 0) && tabuleiro.celulas[x + 1][y - 1] == 0) {
			++bombasVizinhas;
			}
		if (((x - 1) > 0 && (y + 1) < 9) && tabuleiro.celulas[x - 1][y + 1] == 0) {
			++bombasVizinhas;
			}
		tabuleiro.tabuleiro[x][y] = Character.forDigit(bombasVizinhas, 10);
		temBomba = true;
    }
	
	/*public void abrirCasaVizinha() {
	   if(tabuleiro.tabuleiro[x][y] == true) {
		for()
	   }
    }*/
=======
		if ((x - 1) > 0 && tabuleiro.celulas[x - 1][y] == 0) {
			++bombasVizinhas;
			}
		if ((x + 1) < 9 && tabuleiro.celulas[x + 1][y] == 0) {
			++bombasVizinhas;
			} 
		if ((y + 1) < 9 && tabuleiro.celulas[x][y + 1] == 0) {
			++bombasVizinhas;
			} 
		if ((y - 1) > 0 && tabuleiro.celulas[x][y - 1] == 0) {
			++bombasVizinhas;
			} 
		if (((x + 1) < 9 && (y + 1) < 9) && tabuleiro.celulas[x + 1][y + 1] == 0) {
			++bombasVizinhas;
			} 
		if (((x - 1) > 0 && (y - 1) > 0) && tabuleiro.celulas[x - 1][y - 1] == 0) {
			++bombasVizinhas;
			}
		if (((x + 1) < 9 && (y - 1) > 0) && tabuleiro.celulas[x + 1][y - 1] == 0) {
			++bombasVizinhas;
			}
		if (((x - 1) > 0 && (y + 1) < 9) && tabuleiro.celulas[x - 1][y + 1] == 0) {
			++bombasVizinhas;
			}
		tabuleiro.tabuleiro[x][y] = Character.forDigit(bombasVizinhas, 10);
    }
>>>>>>> refs/remotes/origin/main
	
	public void pontuacao() {
		if (tabuleiro.celulas[x][y] == 1) {
			tabuleiro.pontos = tabuleiro.pontos + 100;
		}
	}
	
	public void casaAberta() {
<<<<<<< HEAD
		System.out.println("Casa já aberta.\n");
=======
		System.out.println("Casa jÃ¡ aberta.\n");
>>>>>>> refs/remotes/origin/main
	}
	
	public void abrirCasa() {
		if (tabuleiro.tabuleiro[x][y] == 'B') {
			System.out.println("Casa ocupada por bandeira!\n");
		} else {
			conferirVizinhas();
			pontuacao();
			tabuleiro.marcarTabuleiro();
			System.out.println("");
		}
	}
	
	public void casa() {
		if (tabuleiro.tabuleiro[(x)][y] != '-') {
			casaAberta();
		} else { 
			if (tabuleiro.celulas[(x)][y] == 1) {
				abrirCasa();
			}
		}
	}
	
	public void contadorDeBandeiras() {
		if (tabuleiro.tabuleiro[x][y] == 'B') {
			--tabuleiro.quantidadeDeBandeiras;
			}
	}
	
	public void plantarBandeira() {
		tabuleiro.tabuleiro[x][y] = 'B';
		contadorDeBandeiras();
		tabuleiro.marcarTabuleiro();
		System.out.println("");
	}
	
	public void removerBandeira() {
		tabuleiro.tabuleiro[x][y] = '-';
		++tabuleiro.quantidadeDeBandeiras;
		tabuleiro.marcarTabuleiro();
		System.out.println("");
	}
	
	public void bandeira() {
		if (tabuleiro.tabuleiro[x][y] != 'B') {
			plantarBandeira();
		} else {
			removerBandeira();
		}
		
		if (tabuleiro.quantidadeDeBandeiras < 1) {
			System.out.println("Suas bandeiras acabaram");
<<<<<<< HEAD
			//interacaoComJogador.acoes();
			acoes();

		}
	}
	
	public void acoes() {//nao eh o ideal ficar aqui, se possivel em interacao com o usuario
		System.out.println("Você quer:\nAbrir casa (A)\nColocar uma bandeira (B)");
		acao = input.next().charAt(0);
		if (acao == 'a' || acao == 'A') {
			casa();
		} else if (acao == 'b' || acao == 'B') {
			bandeira();
			} else {
				acoes();
				}
		}
	
	public void receberCoordenadas() {//nao eh o ideal ficar aqui, se possivel em interacao com o usuario
		System.out.print("Insira sua linha: ");
		w = input.nextInt();
		x = (-(w - 9));
		
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
		System.out.println("Havia uma mina, você perdeu.");//adicionar mensagem para quando vencer tambem
		System.out.println("Pontuação total: " + tabuleiro.pontos);
		int pontosTotais = tabuleiro.pontos; //pontuacao para o ranking
	}
	
	public void jogabilidade() {
		do {
			//interacaoComJogador.receberCoordenadas(); - teste com a classe de interacao com o usuario
			//interacaoComJogador.acoes();
			receberCoordenadas();
			acoes();

			if (tabuleiro.celulas[x][y] == 0) {
				gameOver = true;
				fimDeJogo();
				}
		} while (!gameOver);
	}

	public Jogo() {
		jogabilidade();
	}	
}
=======
			acoes();
		}
	}
	
	public void acoes() {
		System.out.println("VocÃª quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
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
		w = input.nextInt();
		x = (-(w - 9));
		
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
		System.out.println("Havia uma mina, vocÃª perdeu.");
		System.out.println("PontuaÃ§Ã£o total: " + tabuleiro.pontos);
	}
	
	public void jogabilidade() {
		do {
			receberCoordenadas();
			acoes();
			if (tabuleiro.celulas[x][y] == 0) {
				gameOver = true;
				fimDeJogo();
				}
		} while (!gameOver);
	}

	public Jogo() {
		jogabilidade();
	}	
}
>>>>>>> refs/remotes/origin/main
