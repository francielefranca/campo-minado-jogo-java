package campoMinado;

import java.util.Random;

import celula.Celula;

import java.util.InputMismatchException;
import excecoes.TamanhoInvalidoException;
import excecoes.AcaoInvalidaException;

import java.time.Duration;
import java.time.Instant;

import jogador.InteracaoComUsuario;
import jogador.Ranking;

public class Jogo extends InteracaoComUsuario {

	private Random sort;
	private Tabuleiro emJogo;
	private Celula casa;
	private Instant comecoDoTempo;
	private Ranking ranking;

	private int linha;
	private int coluna;
	private int minas;
	private int bandeiras;
	
	private int x, y;
	private int pontos;
	private int contador;
	private boolean gameOver;
	private boolean gameWin;

	public void dificuldades(String dificuldade) {
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

	private void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	protected boolean getGameOver() {
		return this.gameOver;
	}
	
	private void setGameWin(boolean gameWin) {
		this.gameWin = gameWin;
	}
	
	protected boolean getGameWin() {
		return this.gameWin;
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
				casa = emJogo.tabuleiro[i][j];
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

	private void abrirCasas(int linhaDoJogador, int colunaDoJogador) { // abre as casas escolhida escolhida pelo jogador e, se não houver vizinhas, abre em cascata
		casa = emJogo.tabuleiro[linhaDoJogador][colunaDoJogador];
		if(casa.getMina()) {
			setGameOver(true);
		} else if(casa.numeroDeMinasVizinhas() != 0) {
			casa.abrirCelula();
			pontuacao();
			} else {
			for(int i = -1; i < 2; i++) {
				for(int j = -1; j < 2; j++) {
					if(linhaDoJogador + i > -1 && linhaDoJogador + i < linha) {
						if(colunaDoJogador + j > -1 && colunaDoJogador + j < coluna) {
							emJogo.tabuleiro[linhaDoJogador + i][colunaDoJogador + j].abrirCelula();
							pontuacao();
						}
					}
				}
			}
		}
	}
	
	private void prepararJogo(int minas, int linha, int coluna) {
		pontos = 0;
		contador = 0;
		emJogo.gerarTabuleiro(linha, coluna);
		sortearMinas(minas, linha, coluna);
		posicionarVizinhas(linha, coluna);
	}

	private void abertura() { // verificacao de abertura de celula
		abrirCasas(this.x, this.y);
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
		casa = emJogo.tabuleiro[this.x][this.y];
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
		casa = emJogo.tabuleiro[this.x][this.y];
		if (casa.getMarcada()) {
			bandeiras--;
		} else {
			bandeiras++;
		}
	}

	private void plantarBandeira() { // marcacao de celula com bandeira
		casa = emJogo.tabuleiro[this.x][this.y];
		casa.setMarcada(true);
		contadorDeBandeiras();
	}

	private void removerBandeira() { // remocao de bandeira da celula
		casa = emJogo.tabuleiro[this.x][this.y];
		casa.setMarcada(false);
		contadorDeBandeiras();
	}

	private void bandeira() { // verificacao do estado da celula para acao de bandeiras
		casa = emJogo.tabuleiro[this.x][this.y];
		if (casa.getFechada()) {
			if (!casa.getMarcada()) {
				plantarBandeira();
				conferirVitoria(minas, this.x, this.y);
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
		if (super.getAcao().equalsIgnoreCase("a")) {
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
	
	public void conferirVitoria(int numeroDeMinas, int linha, int coluna){
		if(emJogo.tabuleiro[linha][coluna].getMina()) {
			if(emJogo.tabuleiro[linha][coluna].getMarcada()) {
				contador++;
				}
			}
        if(contador == numeroDeMinas) {
        	setGameWin(true);
        	}           
    }
	
	private void vitoria(String dificuldade, String nomeDoJogador) {
		System.out.println("Voce limpou o tabuleiro, parabens!!!");
		System.out.println("Pontuacao total: " + pontos);
		ranking.salvarRanking(true, dificuldade, Duration.between(comecoDoTempo, Instant.now()), nomeDoJogador);
	}

	private void fimDeJogo(String dificuldade, String nomeDoJogador) { // exibicao do fim de jogo
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
		ranking.salvarRanking(false, dificuldade, Duration.between(comecoDoTempo, Instant.now()), nomeDoJogador);
	}
	/*
	if(getGameOver()) {
		System.out.println("\n PERDEU :(");
		ranking.salvarRanking(false, nivelDificuldade, Duration.between(start, Instant.now()));
		exibirPontuacao();
		imprimirMenuFinal();
		
		break;
	}else {
		if(jogadorGanhou()) {
			interacaoJogador.nomeJogador();
			System.out.println("\n GANHOU  ");
			ranking.salvarRanking(true, nivelDificuldade, Duration.between(start, Instant.now()));
			exibirPontuacao(); //funciona mesmo se ganhar?
			imprimirMenuFinal();

			break;
		}
	}
	imprimirTabuleiro(linha, coluna);
	 */

	private void jogar(String dificuldade, String nomeDoJogador) { // execucao do jogo
		setGameOver(false);
		setGameWin(false);
		comecoDoTempo = Instant.now();
		do {
			emJogo.tabuleiroEmJogo(getGameOver(), linha, coluna);
			exibirPontuacao();
			exibirBandeiras();
			receberCoordenadas();
			if (getGameOver()) {
				fimDeJogo(dificuldade, nomeDoJogador);
			}
			if(getGameWin()) {
				vitoria(dificuldade, nomeDoJogador);
			}
		} while (!getGameOver() && !getGameWin());
	}

	public Jogo(String dificuldade, String nomeDoJogador) throws NullPointerException { // construtor que inicia o processamento jogo
		if(dificuldade.equals(null)) {
			throw new NullPointerException();
		}
		dificuldades(dificuldade);
		emJogo = new Tabuleiro(linha, coluna);
		prepararJogo(minas, linha, coluna);
		ranking = new Ranking();
		jogar(dificuldade, nomeDoJogador);
	}
	
}
