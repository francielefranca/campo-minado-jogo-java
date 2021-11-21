package jogador;
import java.util.Scanner;

public class InteracaoComUsuario {
	
	private int linha;
	private int coluna;
	private String nomeDoJogador;
	private char dificuldade;
	private char opcoes;
	private char acaoNoJogo;
	
	Scanner input = new Scanner(System.in);
	
	public void setLinha() {
		this.linha = input.nextInt();
		if (this.linha > 8 || this.linha < 1) {
			setLinha();
		}
	}
	
	public int getLinha() {
		return this.linha;
	}
	
	public void setColuna() {
		this.coluna = input.nextInt();
		if (this.coluna > 8 || this.coluna < 1) {
			setColuna();
		}
	}
	
	public int getColuna() {
		return this.coluna;
	}
	
	public void setNome() {
		nomeDoJogador = input.next();
	}
	
	public String getNome() {
		return nomeDoJogador;
	}
	
	public void setDificuldade() {
		this.dificuldade = input.next().charAt(0);
		if (this.dificuldade != '1' & this.dificuldade != '2' & this.dificuldade != '3') {
			setDificuldade();
		}
	}
	
	public int getDificuldade() {
		return this.dificuldade;
	}
	
	public void setOpcao() {
		this.opcoes = input.next().charAt(0);
		if (this.opcoes != '1' & this.opcoes != '2' & this.opcoes != '3') {
			setOpcao();
		}
	}
	
	public int getOpcao() {
		return this.opcoes;
	}
	
	public void setAcao() {
		this.acaoNoJogo = input.next().charAt(0);
		if(this.acaoNoJogo != 'a' & this.acaoNoJogo != 'A' & this.acaoNoJogo != 'b' & this.acaoNoJogo != 'B') {
			setAcao();
		}
	}
	
	public char getAcao() {
		return this.acaoNoJogo;
	}

}