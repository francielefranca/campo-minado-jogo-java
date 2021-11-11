package campoMinado;

import java.util.Scanner;

public class Menu {
	
	Scanner input = new Scanner(System.in);
	String nome;
	char nivel;

	public Menu() {
		
		System.out.print("Digite o seu nome: ");
		nome = input.nextLine();
		opcoesDoMenu();
	}
	
	private void opcoesDoMenu() {
		
		char opcao;
		System.out.print("\nO que você deseja acessar?\n" + "1 - Iniciar jogo\n" + "2 - Seleção de dificuldades\n" + "3 - Regras do Campo Minado\n");
		opcao = input.next().charAt(0);
		System.out.println("");
		
		switch(opcao) {
		case '1':
			new Jogo();
			break;
		case '2':
			dificuldadesDoJogo();
			break;
		case '3':
			regrasDoJogo();
			break;
		default: opcoesDoMenu();
		}
		
		input.close();
	}
	
	private void regrasDoJogo() {
		System.out.print("O jogo consiste em limpar as áreas do tabuleiro sem explodir as minas que estão distribuídas aleatoriamente pelo mesmo. Logo, o jogador deve escolher a coordenada(linha, coluna) de onde deseja cavar, por exemplo: 2 e 5 (linha 2, coluna 5). Se\nna casa 2 e 5 houver uma mina, GAME OVER!\n");
		
		opcoesDoMenu();
	}
	
	private void dificuldadesDoJogo() {
		System.out.print("Escolha a dificuldade do jogo:\n1 - Fácil\n2 - Médio\n3 - Difícil\n");
		nivel = input.next().charAt(0);
		if (nivel == '1' || nivel == '2' || nivel == '3') {
			opcoesDoMenu();
		} else {
			dificuldadesDoJogo();
		}
	}
}