package campoMinado;

import java.util.Random;

import celula.Celula;

import java.util.InputMismatchException;
import excecoes.TamanhoInvalidoException;
import excecoes.AcaoInvalidaException;
import jogador.InteracaoComUsuario;

public class Jogo extends InteracaoComUsuario {

	private Random sort;
	// private Interface telaDoJogo;
	private Tabuleiro emJogo;

	public int linha;
	public int coluna;
	public int minas;
	public int bandeiras;

	public void dificuldades(String dificuldade) {
		if(dificuldade.isBlank()) {
			linha = 9;
			coluna = 9;
			minas = 10;
			bandeiras = 10;
		} else {
			switch (dificuldade) {
			case "1":
				linha = 9;
				coluna = 9;
				minas = 10;
				bandeiras = 10;
				break;
			case "2":
				linha = 16;
				coluna = 16;
				minas = 40;
				bandeiras = 40;
				break;
			case "3":
				linha = 16;
				coluna = 30;
				minas = 99;
				bandeiras = 99;
				break;
			}
		}
	}

	private int x, y;
	private int pontos = 0;
	private boolean gameOver;

	private void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	protected boolean getGameOver() {
		return this.gameOver;
	}

	private void pontuacao() { // pontuacao do jogo
		pontos = pontos + 100;
	}

	private void exibirPontuacao() { // exibir pontuacao
		if (!getGameOver()) {
			System.out.println("Pontuacao: " + pontos);
		}
	}

	private void exibirBandeiras() { // exibe a quantidade de bandeiras remanescentes
		if (!getGameOver()) {
			System.out.println("Bandeiras: " + bandeiras);
		}
	}

	private void posicionarVizinhas(int linha, int coluna) {
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				Celula casa = emJogo.tabuleiro[i][j];
				if (i > 0) {
					if (j > 0) {
						casa.adicionarVizinhas(emJogo.tabuleiro[i - 1][j - 1]);
					}
					casa.adicionarVizinhas(emJogo.tabuleiro[i - 1][j]);
					if (j < coluna - 1) {
						casa.adicionarVizinhas(emJogo.tabuleiro[i - 1][j + 1]);
					}
				}
				if (j > 0) {
					casa.adicionarVizinhas(emJogo.tabuleiro[i][j - 1]);
				}
				if (j < coluna - 1) {
					casa.adicionarVizinhas(emJogo.tabuleiro[i][j + 1]);
				}
				if (i < linha - 1) {
					if (j > 0) {
						casa.adicionarVizinhas(emJogo.tabuleiro[i + 1][j - 1]);
					}
					casa.adicionarVizinhas(emJogo.tabuleiro[i + 1][j]);
					if (j < coluna - 1) {
						casa.adicionarVizinhas(emJogo.tabuleiro[i + 1][j + 1]);
					}
				}
			}
		}
	}

	private void abrir(int linha, int coluna) {
		Celula casa = emJogo.tabuleiro[linha][coluna];
		casa.setFechada(false);
	}

	private void abrirCasas(int linha, int coluna) { // abre as casas escolhida escolhida pelo jogador e, se não houver
														// vizinhas, abre em cascata
		abrir(linha, coluna);
	}

	private void abertura() { // verificacao de abertura de celula
		conferirGameOver();
		if (getGameOver()) {
			return;
		} else {
			abrirCasas(this.x, this.y);
			pontuacao();
		}
	}

	private void casaMarcada() { // mensagem para celula marcada
		System.out.println("Nao pode abrir uma casa marcada");
		receberCoordenadas();
	}

	private void casaAberta() { // mensagem para celula ja aberta
		System.out.println("Casa ja aberta.\n");
		receberCoordenadas();
	}

	private void casa() { // verificacao do estado da celula para acao de casas
		Celula casa = emJogo.tabuleiro[this.x][this.y];
		if (casa.getFechada()) {
			if (casa.getMarcada()) {
				casaMarcada();
			} else {
				abertura();
			}
		} else {
			casaAberta();
		}
	}

	private void contadorDeBandeiras() { // adicao ou subtracao da quantidade de bandeiras
		Celula casa = emJogo.tabuleiro[this.x][this.y];
		if (casa.getMarcada()) {
			bandeiras--;
		} else {
			bandeiras++;
		}
	}

	private void plantarBandeira() { // marcacao de celula com bandeira
		Celula casa = emJogo.tabuleiro[this.x][this.y];
		casa.setMarcada(true);
		contadorDeBandeiras();
	}

	private void removerBandeira() { // remocao de bandeira da celula
		Celula casa = emJogo.tabuleiro[this.x][this.y];
		casa.setMarcada(false);
		contadorDeBandeiras();
	}

	private void bandeira() { // verificacao do estado da celula para acao de bandeiras
		Celula casa = emJogo.tabuleiro[this.x][this.y];
		if (casa.getFechada()) {
			if (!casa.getMarcada()) {
				plantarBandeira();
			} else {
				removerBandeira();
			}
		} else {
			casaAberta();
		}
	}

	private void acoes() { // recebendo a acao escolhida pelo jogador
		try {
			super.setAcao();
		} catch (AcaoInvalidaException acao) {
			System.out.println(acao.getMessage());
			acoes();
		}
		if (super.getAcao() == 'a' || super.getAcao() == 'A') {
			casa();
		} else {
			bandeira();
		}
	}

	private void receberLinha() {
		try {
			super.setLinha(linha);
		} catch (TamanhoInvalidoException tamanho) {
			System.out.println(tamanho.getMessage());
			receberLinha();
		} catch (InputMismatchException tipo) {
			System.out.println("Tipo de entrada invalido, insira apenas numeros");
			receberLinha();
		}
		this.x = (-(super.getLinha() - (linha - 1)));
	}

	private void receberColuna() {
		try {
			super.setColuna(coluna);
		} catch (TamanhoInvalidoException tamanho) {
			System.out.println(tamanho.getMessage());
			receberColuna();
		} catch (InputMismatchException tipo) {
			System.out.println("Tipo de entrada invalido, insira apenas numeros");
			receberColuna();
		}
		this.y = super.getColuna();
	}

	private void receberCoordenadas() { // recebendo coordenadas do jogador, linha e coluna
		receberLinha();
		receberColuna();
		acoes();
	}

	private void sortearMinas(int minas, int linha, int coluna) { // sorteio das minas
		sort = new Random();
		int q = minas;
		int l, c;
		while (q > 0) {
			l = this.sort.nextInt(linha);
			c = this.sort.nextInt(coluna);
			Celula casa = emJogo.tabuleiro[l][c];
			if (!casa.getMina()) {
				casa.minar();
				q--;
			}
		}
	}

	private void conferirGameOver() { // confere se foi encontrada uma mina
		Celula casa = emJogo.tabuleiro[this.x][this.y];
		if (casa.getMina()) {
			setGameOver(true);
		}
	}

	private void fimDeJogo() { // exibicao do fim de jogo
		if (getGameOver()) {
			for (int i = 0; i < linha; i++) {
				for (int j = 0; j < coluna; j++) {
					Celula casa = emJogo.tabuleiro[i][j];
					casa.setFechada(false);
					System.out.print(casa + "   ");
				}
				System.out.println();
			}
			System.out.println("Havia uma mina, voce perdeu.");
			System.out.println("Pontuacao total: " + pontos);
		}
	}

	private void jogar() { // execucao do jogo
		do {
			emJogo.tabuleiroEmJogo(getGameOver(), linha, coluna);
			exibirPontuacao();
			exibirBandeiras();
			receberCoordenadas();
			if (getGameOver()) {
				fimDeJogo();
			}
		} while (!getGameOver());
	}

	public Jogo(String dificuldade) throws NullPointerException { // construtor que inicia o processamento jogo
		setGameOver(false);
		if(dificuldade.equals(null)) {
			throw new NullPointerException();
		}
		dificuldades(dificuldade);
		emJogo = new Tabuleiro(linha, coluna);
		sortearMinas(minas, linha, coluna);
		posicionarVizinhas(linha, coluna);
		// telaDoJogo = new Interface();
		jogar();
	}
}
