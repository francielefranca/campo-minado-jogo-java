package campoMinado;

import jogador.InteracaoComUsuario;

public class Menu extends InteracaoComUsuario{
	
	public Menu() {
		System.out.print("Digite o seu nome: ");
		super.setNome();
		opcoesDoMenu();
	}
	
	private void opcoesDoMenu() {//opcoes do menu do jogo
		
		System.out.print("\nO que você deseja acessar?\n" + "1 - Iniciar jogo\n" + "2 - Regras do jogo\n");
		super.setOpcao();
		System.out.println("");
		
		switch(super.getOpcao()) {
		
		case '1':
			new Jogo();
			break;
		case '2':
			regrasDoJogo();
			break;
		default: opcoesDoMenu();
		
		}
	}
	
	private void regrasDoJogo() {//explicacao de como o jogo funciona
		System.out.println("O jogo consiste em limpar as áreas do tabuleiro sem explodir as minas que estão distribuídas aleatóriamente pelo mesmo. Logo, jogador deve escolher a coordenada(linha, coluna) de onde deseja revelar ou marcar com uma banderia, por exemplo: 2 e 5 (linha 2, coluna 5). Se\nna casa 2 e 5 houver uma mina, GAME OVER!\n");
		opcoesDoMenu();
	}
}
