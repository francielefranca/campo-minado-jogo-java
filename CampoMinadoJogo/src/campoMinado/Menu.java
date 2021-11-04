package campoMinado;

import java.util.Scanner;

public class Menu {
	
	//HAHAHAHAHAHAHAHAHAH RONALDINHO SOCCER
	
	Scanner input = new Scanner(System.in);
	
	String nome;
	int nivel;

	public static void main(String[] args) {
		int opcao = 3;	

		System.out.println("Digite o seu nome:"); //recebendo o nome do jogador
		//nome = input.nextLine();
		//opcao = input.nextInt();
		//input.close();
		
		
	switch(opcao) {
	case 1:
		System.out.println("Jogar");
		break;
	case 2:
		System.out.println("Configuracoes");
		break;
	case 3:
		System.out.println("Regras do jogo");
		break;
	default: System.out.println("Opcao invalida!");

	}

	}
}
