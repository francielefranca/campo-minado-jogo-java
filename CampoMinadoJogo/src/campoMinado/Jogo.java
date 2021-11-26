package campoMinado;

import jogador.InteracaoComUsuario;

public class Jogo extends InteracaoComUsuario {;

	Tabuleiro tabuleiro;
	Celula casas;
	
	private int x, y;
	
	private int bombasVizinhas;
	
	protected int pontos = 0;
	
	protected boolean gameOver;
	
	private void conferirVizinhas(int x, int y) {// verificacao de celulas vizinhas
		bombasVizinhas = 0;
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(casas.celulas[x + i][y + j] == 1 && (x + i) < 9 && (x - i) >= 0 && (y + j) < 9 && (y - j) >= 0) {
					++this.bombasVizinhas;
				}
			}
		}
    }
	
	private void abrirCasa(int x, int y) {//abrir as celulas, verificando as vizinhas antes
		conferirVizinhas(x, y);
		tabuleiro.casas.celulas[x][y] = this.bombasVizinhas;
	}
	
	private void abrirCasasVizinhas(int x, int y) {//abrir as celulas vizinhas, quando a celula for igual a zero
		if(tabuleiro.casas.celulas[x][y] == 0) {
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					if(casas.celulas[x + i][y + j] != 1) {
						if(x + i > 0 && x + i <= 9) {
							if(y + j > 0 && y + j <= 9) {
								abrirCasa(x + i, y + j);
							}
						}
					}
				}
			}
		} 
	}
	
	private void pontuacao() {//pontuacao do jogo
		pontos = pontos + 100;
	}
	
	private void casaAberta() {//mensagem para celula ja aberta
		System.out.println("Casa já aberta.\n");
	}
	
	private void exibirPontuacao() {
		if(this.gameOver == false) {
			System.out.println("Pontuação: " + pontos);
		}
	}
	
	private void abertura() {//verificacao de abertura de celula 
		if (tabuleiro.casas.celulas[this.x][this.y] == 8) {
			System.out.println("Casa ocupada por bandeira!\n");
		}
		conferirGameOver();
		if(gameOver) {
			return;
		} else {
			pontuacao();
			abrirCasa(this.x, this.y);
			abrirCasasVizinhas(this.x, this.y);
			}
	}
	
	private void casa() {
			if (tabuleiro.casas.celulas[this.x][this.y] == 9) {
				abertura();
			} else if(tabuleiro.casas.celulas[this.x][this.y] < 8) {
				casaAberta();
				}
			}
	
	private void contadorDeBandeiras() {//adicao ou subtracao da quantidade de bandeiras
		if (tabuleiro.casas.celulas[this.x][this.y] == 8) {
			--tabuleiro.quantidadeDeBandeiras;
			} else {
				++tabuleiro.quantidadeDeBandeiras;
			}
	}
	
	private void plantarBandeira() {//marcacao de celula com bandeira
		if(tabuleiro.casas.celulas[this.x][this.y] != 9) {
			System.out.println("Não se pode colocar bandeiras em casas abertas\n");
			return;
		} else {
			tabuleiro.casas.celulas[this.x][this.y] = 8;
			contadorDeBandeiras();
		}
	}
	
	private void removerBandeira() {//remocao de celula com bandeira
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
	
	private void acoes() {//recebendo a acao escolhida do jogador, abrir celula ou colocar uma bandeira
		System.out.println("Você quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		super.setAcao();
		if (super.getAcao() == 'a' | super.getAcao() == 'A') {
			casa();
		} else {
			bandeira();
			}
		}
	
	private void receberCoordenadas() {//recebendo coordenadas do jogador, linha e coluna 
		System.out.print("Insira sua linha: ");
		super.setLinha(9);
		this.x = (-(super.getLinha() - 9));
		System.out.print("Insira sua coluna: ");
		super.setColuna(9);
		this.y = super.getColuna();
	}
	
	private void conferirGameOver() {
		if(casas.celulas[this.x][this.y] == 1) {
			this.gameOver = true;
		}
	}
		
	private void fimDeJogo(int linha, int coluna) {//game over
		for (int i = 1; i <= linha ; i++) {
			for (int j = 1; j <= coluna; j++) {
				System.out.print(casas.celulas[i][j] + "   ");
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
				fimDeJogo(9, 9);
				}
		} while (!this.gameOver);
	}
	
	public Jogo() {
		tabuleiro = new Tabuleiro();
		casas = new Celula();
		jogo();
	}
}
