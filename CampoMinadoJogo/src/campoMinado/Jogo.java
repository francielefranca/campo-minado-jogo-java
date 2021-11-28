package campoMinado;

import jogador.InteracaoComUsuario;

public class Jogo extends InteracaoComUsuario {;

	Tabuleiro tabuleiro;
	Celula casas;
	
	private int x, y;
	
	private int bombasVizinhas;
	
	protected int pontos = 0;
	
	protected boolean gameOver;
	
	private void conferirVizinhas(int x, int y) { //verificação de células vizinhas
		bombasVizinhas = 0;
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(casas.celulas[x + i][y + j] == 'M' && (x + i) < 9 && (x - i) >= 0 && (y + j) < 9 && (y - j) >= 0) {
					++this.bombasVizinhas;
				}
			}
		}
    }
	
	private void abrirCasa(int x, int y) { //abrir as células, verificando as vizinhas antes
		conferirVizinhas(x, y);
		tabuleiro.casas.celulas[x][y] = Character.forDigit(this.bombasVizinhas, 10);
	}
	
	private void abrirCasasVizinhas(int x, int y) { //abrir as células vizinhas, quando a célula for vazia
		if(tabuleiro.casas.celulas[x][y] == '0') {
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					if(casas.celulas[x + i][y + j] != 'M') {
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
	
	private void pontuacao() { //pontuação do jogo
		pontos = pontos + 100;
	}
	
	private void casaAberta() { //mensagem para célula já aberta
		System.out.println("Casa já aberta.\n");
	}
	
	private void casaComBandeira() { //mensagem para célula marcada
		System.out.println("Casa ocupada por bandeira!");
	}
	
	private void exibirPontuacao() { //exibir pontuação
		if(this.gameOver == false) {
			System.out.println("Pontuação: " + pontos);
		}
	}
	
	private void abertura() { //verificação de abertura de célula 
		conferirGameOver();
		if(gameOver) {
			return;
		} else {
			pontuacao();
			abrirCasa(this.x, this.y);
			abrirCasasVizinhas(this.x, this.y);
			}
	}
	
	private void casa() { //verificação do estado da célula para ação de casas
			if (tabuleiro.casas.celulas[this.x][this.y] == '-') {
				abertura();
			} else if(tabuleiro.casas.celulas[this.x][this.y] == 'B') {
				casaComBandeira();
				} else {
					casaAberta();
				}
			}
	
	private void contadorDeBandeiras() { //adição ou subtração da quantidade de bandeiras
		if (tabuleiro.casas.celulas[this.x][this.y] == 'B') {
			--tabuleiro.quantidadeDeBandeiras;
			} else {
				++tabuleiro.quantidadeDeBandeiras;
			}
	}
	
	private void plantarBandeira() { //marcação de célula com bandeira
		tabuleiro.casas.celulas[this.x][this.y] = 'B';
		contadorDeBandeiras();
	}
	
	private void removerBandeira() { //remoção de bandeira da célula
		tabuleiro.casas.celulas[this.x][this.y] = '-';
		contadorDeBandeiras();
	}
	
	private void bandeira() { //verificação do estado da célula para ação de bandeiras
		if(tabuleiro.casas.celulas[this.x][this.y] == '-') {
			plantarBandeira();
		} else if(tabuleiro.casas.celulas[this.x][this.y] == 'B') {
			removerBandeira();
			} else {
				casaAberta();
			}
		
		if (tabuleiro.quantidadeDeBandeiras < 1) {
			System.out.println("Suas bandeiras acabaram");
			acoes();
		}
	}
	
	private void acoes() { //recebendo a ação escolhida pelo jogador
		System.out.println("Você quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		super.setAcao();
		if (super.getAcao() == 'a' | super.getAcao() == 'A') {
			casa();
		} else {
			bandeira();
			}
		}
	
	private void receberCoordenadas() { //recebendo coordenadas do jogador, linha e coluna
		System.out.print("Insira sua linha: ");
		super.setLinha(9);
		this.x = (-(super.getLinha() - 9));
		System.out.print("Insira sua coluna: ");
		super.setColuna(9);
		this.y = super.getColuna();
	}
	
	private void conferirGameOver() {
		if(casas.celulas[this.x][this.y] == 'M') {
			this.gameOver = true;
		}
	}
		
	private void fimDeJogo(int linha, int coluna) { //exibição do fim de jogo
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
	
	protected void jogo() { //execução do jogo
		do {
			receberCoordenadas();
			acoes();
			tabuleiro.imprimirTabuleiro(gameOver);
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
