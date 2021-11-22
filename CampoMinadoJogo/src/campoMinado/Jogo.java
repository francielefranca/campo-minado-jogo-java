package campoMinado;

import jogador.InteracaoComUsuario;

public class Jogo extends InteracaoComUsuario {
	
	Celula posicao = new Celula();
	Tabuleiro tabuleiro = new Tabuleiro();
	
	int y, x;
	
	int bombasVizinhas;
	
	boolean gameOver;
	
	private void conferirVizinhas() {
		
		bombasVizinhas = 0;
		
		if ((this.x - 1) > 0 && posicao.celulas[this.x - 1][this.y] == 1) {
			++this.bombasVizinhas;
			}
		if ((this.x + 1) < 10 && posicao.celulas[this.x + 1][this.y] == 1) {
			++this.bombasVizinhas;
			} 
		if ((this.y + 1) < 10 && posicao.celulas[this.x][this.y + 1] == 1) {
			++this.bombasVizinhas;
			} 
		if ((this.y - 1) > 0 && posicao.celulas[this.x][this.y - 1] == 1) {
			++this.bombasVizinhas;
			} 
		if (((this.x + 1) < 10 && (this.y + 1) < 10) && posicao.celulas[this.x + 1][this.y + 1] == 1) {
			++this.bombasVizinhas;
			} 
		if (((this.x - 1) > 0 && (this.y - 1) > 0) && posicao.celulas[this.x - 1][this.y - 1] == 1) {
			++this.bombasVizinhas;
			}
		if (((this.x + 1) < posicao.linha + 1 && (this.y - 1) > 0) && posicao.celulas[this.x + 1][this.y - 1] == 1) {
			++this.bombasVizinhas;
			}
		if (((this.x - 1) > 0 && (this.y + 1) < posicao.coluna + 1) && posicao.celulas[this.x - 1][this.y + 1] == 1) {
			++this.bombasVizinhas;
			}
		tabuleiro.casas.celulas[this.x][this.y] = this.bombasVizinhas;
		
    }
	
	private void pontuacao() {
		tabuleiro.casas.pontos = tabuleiro.casas.pontos + 100;
	}
	
	private void casaAberta() {
		System.out.println("Casa já aberta.\n");
	}
	
	private void abrirCasa() {
		if (tabuleiro.casas.celulas[this.x][this.y] == 8) {
			System.out.println("Casa ocupada por bandeira!\n");
		} else {
			conferirGameOver();
			pontuacao();
			conferirVizinhas();
			tabuleiro.marcarTabuleiro(gameOver);
			System.out.println("");
		}
	}
	
	private void casa() {
			if (tabuleiro.casas.celulas[this.x][this.y] == 9) {
				abrirCasa();
			} else if(tabuleiro.casas.celulas[this.x][this.y] < 8) {
				casaAberta();
				}
			}
	
	private void contadorDeBandeiras() {
		if (tabuleiro.casas.celulas[this.x][this.y] == 8) {
			--tabuleiro.casas.quantidadeDeBandeiras;
			} else {
				++tabuleiro.casas.quantidadeDeBandeiras;
			}
	}
	
	private void plantarBandeira() {
		tabuleiro.casas.celulas[this.x][this.y] = 8;
		contadorDeBandeiras();
		tabuleiro.marcarTabuleiro(gameOver);
		System.out.println("");
	}
	
	private void removerBandeira() {
		tabuleiro.casas.celulas[this.x][this.y] = 9;
		contadorDeBandeiras();
		tabuleiro.marcarTabuleiro(gameOver);
		System.out.println("");
	}
	
	private void bandeira() {
		if (tabuleiro.casas.celulas[this.x][this.y] != 8) {
			plantarBandeira();
		} else {
			removerBandeira();
		}
		
		if (posicao.quantidadeDeBandeiras < 1) {
			System.out.println("Suas bandeiras acabaram");
			acoes();
		}
	}
	
	private void acoes() {
		System.out.println("Você quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		setAcao();
		if (getAcao() == 'a' || getAcao() == 'A') {
			casa();
		} else {
			bandeira();
			}
		}
	
	private void receberCoordenadas() {
		System.out.print("Insira sua linha: ");
		setLinha();
		this.x = (-(getLinha() - 10));
		System.out.print("Insira sua coluna: ");
		setColuna();
		this.y = getColuna();
	}
	
	private void conferirGameOver() {
		if(posicao.celulas[this.x][this.y] == 1) {
			gameOver = true;
		}
	}
		
	private void fimDeJogo() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (posicao.celulas[i][j] == 1) {
				}
				System.out.print(posicao.celulas[i][j] + "   ");
			}
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("Havia uma mina, você perdeu.");
		System.out.println("Pontuação total: " + tabuleiro.casas.pontos);
	}
	
	private void jogo() {
		do {
			receberCoordenadas();
			acoes();
			if (this.gameOver) {
				fimDeJogo();
				}
		} while (!this.gameOver);
	}

	public Jogo() {
		jogo();
	}	
}
