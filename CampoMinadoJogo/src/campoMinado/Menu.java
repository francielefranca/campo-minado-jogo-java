package campoMinado;

import excecoes.OpcaoInvalidaException;
import jogador.InteracaoComUsuario;

public class Menu extends InteracaoComUsuario {
	
	Jogo iniciar;

	public Menu() throws OpcaoInvalidaException {
		super.setNome();
		opcoesDoMenu();
	}

	private void opcoesDoMenu() throws OpcaoInvalidaException {// opcoes do menu do jogo
		try{
			super.setOpcao();
		} catch(OpcaoInvalidaException opcao) {
			System.out.println(opcao.getMessage());
			opcoesDoMenu();
		}
		switch (super.getOpcao()) {
		case '1':
			try {
				iniciar = new Jogo(getDificuldade());
			} catch (NullPointerException nula) {
				System.out.println("Antes de comecar, escolha uma dificuldade"); 
				seletorDeDificuldades();
			}
			break;
		case '2':
			regrasDoJogo();
			break;
		case '3':
			seletorDeDificuldades();
			break;
		}
	}

	private void regrasDoJogo() throws OpcaoInvalidaException {// explicacao de como o jogo funciona
		System.out.println("O jogo consiste em limpar o tabuleiro sem explodir as minas que estao\ndistribuidas aleatoriamente pelo mesmo. Logo,o jogador deve escolher\na coordenada(linha, coluna) de onde deseja revelar ou marcar com uma\nbanderia, por exemplo: 2 e 5 (linha 2, coluna 5). Se na casa (2,5) houver\numa mina... GAME OVER!");
		opcoesDoMenu();
	}
	
	private void seletorDeDificuldades() throws OpcaoInvalidaException {
		try {
			super.setDificuldade();
		} catch(OpcaoInvalidaException dificuldade) {
			System.out.println(dificuldade.getMessage());
			seletorDeDificuldades();
		}
		opcoesDoMenu();
	}
}
