package campoMinado;

import jogador.InteracaoComUsuario;

public class Jogo extends InteracaoComUsuario {
	
	Celula posicao = new Celula();
	Tabuleiro tabuleiro = new Tabuleiro();
	
	int y, x;
	
	int bombasVizinhas;
	
	boolean gameOver;
	
	public void conferirVizinhas() {
		
		bombasVizinhas = 0;
		
		if ((this.x - 1) > 0 && posicao.celulas[this.x - 1][this.y] == 1) {
			++this.bombasVizinhas;
			}
		if ((this.x + 1) < 9 && posicao.celulas[this.x + 1][this.y] == 1) {
			++this.bombasVizinhas;
			} 
		if ((this.y + 1) < 9 && posicao.celulas[this.x][this.y + 1] == 1) {
			++this.bombasVizinhas;
			} 
		if ((this.y - 1) > 0 && posicao.celulas[this.x][this.y - 1] == 1) {
			++this.bombasVizinhas;
			} 
		if (((this.x + 1) < 9 && (this.y + 1) < 9) && posicao.celulas[this.x + 1][this.y + 1] == 1) {
			++this.bombasVizinhas;
			} 
		if (((this.x - 1) > 0 && (this.y - 1) > 0) && posicao.celulas[this.x - 1][this.y - 1] == 1) {
			++this.bombasVizinhas;
			}
		if (((this.x + 1) < 9 && (this.y - 1) > 0) && posicao.celulas[this.x + 1][this.y - 1] == 1) {
			++this.bombasVizinhas;
			}
		if (((this.x - 1) > 0 && (this.y + 1) < 9) && posicao.celulas[this.x - 1][this.y + 1] == 1) {
			++this.bombasVizinhas;
			}
		tabuleiro.casas.celulas[this.x][this.y] = this.bombasVizinhas;
		
    }
	
	public void pontuacao() {
		tabuleiro.casas.pontos = tabuleiro.casas.pontos + 100;
	}
	
	public void casaAberta() {
		System.out.println("Casa já aberta.\n");
	}
	
	public void abrirCasa() {
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
	
	public void casa() {
			if (tabuleiro.casas.celulas[this.x][this.y] == 9) {
				abrirCasa();
			} else if(tabuleiro.casas.celulas[this.x][this.y] < 8) {
				casaAberta();
				}
			}
	
	public void contadorDeBandeiras() {
		if (tabuleiro.casas.celulas[this.x][this.y] == 8) {
			--tabuleiro.casas.quantidadeDeBandeiras;
			} else {
				++tabuleiro.casas.quantidadeDeBandeiras;
			}
	}
	
	public void plantarBandeira() {
		tabuleiro.casas.celulas[this.x][this.y] = 8;
		contadorDeBandeiras();
		tabuleiro.marcarTabuleiro(gameOver);
		System.out.println("");
	}
	
	public void removerBandeira() {
		tabuleiro.casas.celulas[this.x][this.y] = 9;
		contadorDeBandeiras();
		tabuleiro.marcarTabuleiro(gameOver);
		System.out.println("");
	}
	
	public void bandeira() {
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
		this.x = (-(getLinha() - 9));
		System.out.print("Insira sua coluna: ");
		setColuna();
		this.y = getColuna();
	}
	
	public void conferirGameOver() {
		if(posicao.celulas[this.x][this.y] == 1) {
			gameOver = true;
		}
	}
		
	public void fimDeJogo() {
		for (posicao.linha = 1; posicao.linha < 9; posicao.linha++) {
			for (posicao.coluna= 1; posicao.coluna < 9; posicao.coluna++) {
				if (posicao.celulas[posicao.linha][posicao.coluna] == 1) {
				}
				System.out.print(posicao.celulas[posicao.linha][posicao.coluna] + "   ");
			}
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("Havia uma mina, você perdeu.");
		System.out.println("Pontuação total: " + tabuleiro.casas.pontos);
	}
	
	public void jogo() {
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
