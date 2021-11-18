package campoMinado;
import java.util.Scanner;

public class InteracaoComUsuario {
	
	private int linha;
	private int coluna;
	private String nomeDoJogador;
	private int dificuldade;
	private int opcoes;
	private char acaoNoJogo;
	
	Scanner input = new Scanner(System.in);
	
	public void setLinha() {
		linha = input.nextInt();
		if (linha > 8 || linha < 1) {
			setLinha();
		}
	}
	
	public int getLinha() {
		return linha;
	}
	
	public void setColuna() {
		coluna = input.nextInt();
		if (coluna > 8 || coluna < 1) {
			setColuna();
		}
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public void setNome() {
		nomeDoJogador = input.next();
	}
	
	public String getNome() {
		return nomeDoJogador;
	}
	
	public void setDificuldade() {
		dificuldade = input.nextInt();
		if (dificuldade != 1 & dificuldade != 2 & dificuldade != 3) {
			setDificuldade();
		}
	}
	
	public int getDificuldade() {
		return dificuldade;
	}
	
	public void setOpcao() {
		opcoes = input.nextInt();
		if (opcoes != 1 & opcoes != 2 & opcoes != 3) {
			setOpcao();
		}
	}
	
	public int getOpcao() {
		return opcoes;
	}
	
	public void setAcao() {
		acaoNoJogo = input.next().charAt(0);
		if(acaoNoJogo != 'a' & acaoNoJogo != 'A' & acaoNoJogo != 'b' & acaoNoJogo != 'B') {
			setAcao();
		}
	}
	
	public char getAcao() {
		return acaoNoJogo;
	}

}