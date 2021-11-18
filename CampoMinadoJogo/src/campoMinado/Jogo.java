package campoMinado;

public class Jogo extends InteracaoComUsuario {
	
	int y, x;
	
	int bombasVizinhas;
	
	boolean gameOver;
	
	Tabuleiro casas = new Tabuleiro();
	Celula minas = new Celula();
	
	public void conferirVizinhas() {
		bombasVizinhas = 0;
		
		if ((x - 1) > 0 && minas.celulas[x - 1][y] == 0) {
			++bombasVizinhas;
			}
		if ((x + 1) < 9 && minas.celulas[x + 1][y] == 0) {
			++bombasVizinhas;
			} 
		if ((y + 1) < 9 && minas.celulas[x][y + 1] == 0) {
			++bombasVizinhas;
			} 
		if ((y - 1) > 0 && minas.celulas[x][y - 1] == 0) {
			++bombasVizinhas;
			} 
		if (((x + 1) < 9 && (y + 1) < 9) && minas.celulas[x + 1][y + 1] == 0) {
			++bombasVizinhas;
			} 
		if (((x - 1) > 0 && (y - 1) > 0) && minas.celulas[x - 1][y - 1] == 0) {
			++bombasVizinhas;
			}
		if (((x + 1) < 9 && (y - 1) > 0) && minas.celulas[x + 1][y - 1] == 0) {
			++bombasVizinhas;
			}
		if (((x - 1) > 0 && (y + 1) < 9) && minas.celulas[x - 1][y + 1] == 0) {
			++bombasVizinhas;
			}
		casas.tabuleiro[x][y] = Character.forDigit(bombasVizinhas, 10);
    }
	
	public void pontuacao() {
		if (minas.celulas[x][y] == 1) {
			minas.pontos = minas.pontos + 100;
		}
	}
	
	public void casaAberta() {
		System.out.println("Casa já aberta.\n");
	}
	
	public void abrirCasa() {
		if (casas.tabuleiro[x][y] == 'B') {
			System.out.println("Casa ocupada por bandeira!\n");
		} else {
			conferirVizinhas();
			pontuacao();
			casas.marcarTabuleiro();
			System.out.println("");
		}
	}
	
	public void casa() {
		if (casas.tabuleiro[(x)][y] != '-') {
			casaAberta();
		} else { 
			if (minas.celulas[(x)][y] == 1) {
				abrirCasa();
			}
		}
	}
	
	public void contadorDeBandeiras() {
		if (casas.tabuleiro[x][y] == 'B') {
			--minas.quantidadeDeBandeiras;
			}
	}
	
	public void plantarBandeira() {
		casas.tabuleiro[x][y] = 'B';
		contadorDeBandeiras();
		casas.marcarTabuleiro();
		System.out.println("");
	}
	
	public void removerBandeira() {
		casas.tabuleiro[x][y] = '-';
		++minas.quantidadeDeBandeiras;
		casas.marcarTabuleiro();
		System.out.println("");
	}
	
	public void bandeira() {
		if (casas.tabuleiro[x][y] != 'B') {
			plantarBandeira();
		} else {
			removerBandeira();
		}
		
		if (minas.quantidadeDeBandeiras < 1) {
			System.out.println("Suas bandeiras acabaram");
			acoes();
		}
	}
	
	public void acoes() {
		System.out.println("Você quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		setAcao();
		if (getAcao() == 'a' || getAcao() == 'A') {
			casa();
		} else {
			bandeira();
			}
		}
	
	public void receberCoordenadas() {
		System.out.print("Insira sua linha: ");
		setLinha();
		x = (-(getLinha() - 9));
		System.out.print("Insira sua coluna: ");
		setColuna();
		y = getColuna();
	}
		
	public void fimDeJogo() {
		System.out.println("\n       Linhas\n");
		for (int i = 1; i < 9; i++) {
			System.out.print("       " + (-(i - 9)) + " ");
			for (int j = 1; j < 9; j++) {
				if (minas.celulas[i][j] == 0) {
					casas.tabuleiro[i][j] = 'X';
				}
				System.out.print("   " + casas.tabuleiro[i][j]);
			}
			System.out.println("");
		}
		System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("\n				  Colunas");
		
		System.out.println("");
		System.out.println("Havia uma mina, você perdeu.");
		System.out.println("Pontuação total: " + minas.pontos);
	}
	
	public void jogo() {
		do {
			receberCoordenadas();
			acoes();
			if (minas.celulas[x][y] == 0) {
				gameOver = true;
				fimDeJogo();
				}
		} while (!gameOver);
	}

	public Jogo() {
		jogo();
	}	
}
