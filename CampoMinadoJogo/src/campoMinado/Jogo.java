package campoMinado;

import jogador.InteracaoComUsuario;

public class Jogo extends InteracaoComUsuario {;

	Tabuleiro tabuleiro = new Tabuleiro();
	Celula casas = new Celula();
	
	private int x, y;
	
	private int bombasVizinhas;
	
	protected int pontos = 0;
	
	protected boolean gameOver;
	
	private void conferirVizinhas() {
		bombasVizinhas = 0;
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(casas.celulas[this.x + i][this.y + j] == 1 && (this.x + i) <= 16 && (this.x - i) > 0 && (this.y + j) <= 16 && (this.y - j) > 0) {
					++this.bombasVizinhas;
				}
			}
		}
		tabuleiro.casas.celulas[this.x][this.y] = this.bombasVizinhas;
    }
	
	private void pontuacao() {
		if(this.gameOver) {
			return;
		} else {
			pontos = pontos + 100;
		}
	}
	
	private void casaAberta() {
		System.out.println("Casa já aberta.\n");
	}
	
	private void exibirPontuacao() {
		if(this.gameOver == false) {
			System.out.println("Pontuação: " + pontos);
		}
	}
	
	private void abrirCasa() {
		if (tabuleiro.casas.celulas[this.x][this.y] == 8) {
			System.out.println("Casa ocupada por bandeira!\n");
		} else {
			conferirGameOver();
			pontuacao();
			conferirVizinhas();
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
			--tabuleiro.quantidadeDeBandeiras;
			} else {
				++tabuleiro.quantidadeDeBandeiras;
			}
	}
	
	private void plantarBandeira() {
		tabuleiro.casas.celulas[this.x][this.y] = 8;
		contadorDeBandeiras();
	}
	
	private void removerBandeira() {
		tabuleiro.casas.celulas[this.x][this.y] = 9;
		contadorDeBandeiras();
	}
	
	private void bandeira() {
		if (tabuleiro.casas.celulas[this.x][this.y] != 8) {
			plantarBandeira();
		} else {
			removerBandeira();
		}
		
		if (tabuleiro.quantidadeDeBandeiras < 1) {
			System.out.println("Suas bandeiras acabaram");
			acoes();
		}
	}
	
	private void acoes() {
		System.out.println("Você quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		super.setAcao();
		if (super.getAcao() == 'a' | super.getAcao() == 'A') {
			casa();
		} else {
			bandeira();
			}
		}
	
	private void receberCoordenadas() {
		System.out.print("Insira sua linha: ");
		super.setLinha();
		this.x = (-(super.getLinha() - 16));
		System.out.print("Insira sua coluna: ");
		super.setColuna();
		this.y = super.getColuna();
	}
	
	private void conferirGameOver() {
		if(casas.celulas[this.x][this.y] == 1) {
			this.gameOver = true;
		}
	}
		
	private void fimDeJogo() {
		for (tabuleiro.linha = 1; tabuleiro.linha <= 16 ; tabuleiro.linha++) {
			for (tabuleiro.coluna= 1; tabuleiro.coluna <= 16; tabuleiro.coluna++) {
				if (casas.celulas[tabuleiro.linha][tabuleiro.coluna] == 1) {
				}
				System.out.print(casas.celulas[tabuleiro.linha][tabuleiro.coluna] + "   ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Havia uma mina, você perdeu.");
		System.out.println("Pontuação total: " + pontos);
	}
	
	protected void jogo() {
		do {
			receberCoordenadas();
			acoes();
			tabuleiro.marcarTabuleiro(gameOver);
			exibirPontuacao();
			if (this.gameOver) {
				fimDeJogo();
				}
		} while (!this.gameOver);
	}
	
	public Jogo() {
		jogo();
	}
}
