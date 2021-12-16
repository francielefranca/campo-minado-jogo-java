package jogador;

import java.util.Scanner;

import excecoes.TamanhoInvalidoException;
import excecoes.AcaoInvalidaException;
import excecoes.OpcaoInvalidaException;

public class InteracaoComUsuario {

	private int linhaDeEntrada;
	private int colunaDeEntrada;
	protected String nomeDoJogador;
	private String opcao;
	private String acaoNoJogo;
	protected String dificuldadeDoJogo;

	private Scanner inputLinha;
	private Scanner inputColuna;
	private Scanner inputNome;
	private Scanner inputOpcao;
	private Scanner inputAcao;
	private Scanner inputDificuldade;

	protected void setLinha(int linha) throws TamanhoInvalidoException { // modificacao na linha de acordo com
																			// o que foi recebido do jogador
		inputLinha = new Scanner(System.in);
		System.out.print("Insira sua linha: ");
		this.linhaDeEntrada = inputLinha.nextInt();
		if (linhaDeEntrada > linha || linhaDeEntrada < 1) {
			throw new TamanhoInvalidoException("Tamanho invalido.");
		}
	}

	protected int getLinha() {
		return this.linhaDeEntrada - 1;
	}

	protected void setColuna(int coluna) throws TamanhoInvalidoException { // modificacao na coluna de acordo com
																			// o que foi recebido do jogador
		inputColuna = new Scanner(System.in);
		System.out.print("Insira sua coluna: ");
		this.colunaDeEntrada = inputColuna.nextInt();
		if (colunaDeEntrada > coluna || colunaDeEntrada < 1) {
			throw new TamanhoInvalidoException("Tamanho invalido.");
		}
	}

	protected int getColuna() {
		return this.colunaDeEntrada - 1;
	}

	protected void setNome() { // modificacao no nome do jogador
		inputNome = new Scanner(System.in);
		System.out.print("Digite o seu nome: ");
		this.nomeDoJogador = inputNome.next();
	}

	protected String getNome() {
		return this.nomeDoJogador;
	}

	protected void setOpcao() throws OpcaoInvalidaException { // modificacao na opcao do menu
		inputOpcao = new Scanner(System.in);
		this.opcao = inputOpcao.next();
		if (!this.opcao.equals("1")) {
			if (!this.opcao.equals("2")) {
				if (!this.opcao.equals("3")) {
					throw new OpcaoInvalidaException("Opcao invalida.");
				}
			}
		}
	}

	protected String getOpcao() {
		return this.opcao;
	}

	protected void setAcao() throws AcaoInvalidaException { // verificacao se o que foi digitado pelo jogador na escolha
															// das acoes eh valido
		inputAcao = new Scanner(System.in);
		System.out.println("Voce quer:\nAbrir casa (A)\nPlantar uma bandeira (B)");
		this.acaoNoJogo = inputAcao.next();
		if (!this.acaoNoJogo.equalsIgnoreCase("a")) {
			if (!this.acaoNoJogo.equalsIgnoreCase("b")) {
				throw new AcaoInvalidaException("Acao invalida.");
			}
		}
	}

	protected String getAcao() {
		return this.acaoNoJogo;
	}

	protected void setDificuldade() throws OpcaoInvalidaException {
		inputDificuldade = new Scanner(System.in);
		this.dificuldadeDoJogo = inputDificuldade.next();
		if (!this.dificuldadeDoJogo.equals("1")) {
			if (!this.dificuldadeDoJogo.equals("2")) {
				if (!this.dificuldadeDoJogo.equals("3")) {
					throw new OpcaoInvalidaException("Opcao invalida.");
				}
			}
		}
	}

	protected String getDificuldade() {
		return this.dificuldadeDoJogo;
	}

}
