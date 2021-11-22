package campoMinado;

import jogador.InteracaoComUsuario;

public class Menu extends InteracaoComUsuario {
	
	public Menu() {
		
		System.out.print("Digite o seu nome: ");
		setNome();
		opcoesDoMenu();
	}
	
	private void opcoesDoMenu() {
		
		System.out.print("\nO que voce deseja acessar?\n" + "1 - Iniciar jogo\n" + "2 - Selecao de dificuldade\n" + "3 - Regras do Campo Minado\n");
		setOpcao();
		System.out.println("");
		
		switch(getOpcao()) {
		
		case 1:
			new Jogo();
			break;
		case 2:
			dificuldadesDoJogo();
			break;
		case 3:
			regrasDoJogo();
			break;
		default: opcoesDoMenu();
		
		}
	}
	
	private void regrasDoJogo() {
		System.out.println("O jogo consiste em limpar as areas do tabuleiro sem explodir as minas que estão distribuidas aleatoriamente pelo mesmo. Logo, jogador deve escolher a coordenada(linha, coluna) de onde deseja revelar ou marcar com uma banderia, por exemplo: 2 e 5 (linha 2, coluna 5). Se\nna casa 2 e 5 houver uma mina, GAME OVER!\n");
		opcoesDoMenu();
	}
	
	private void dificuldadesDoJogo() {
		System.out.print("Escolha a dificuldade do jogo:\n1 - Facil\n2 - Medio\n3 - Dificil\n");
		setDificuldade();
		opcoesDoMenu();
	}
}
