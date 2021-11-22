package jogador;
import java.util.Scanner;

public class InteracaoComUsuario {
	
	private int linha;
	private int coluna;
	private String nomeDoJogador;
	private char opcoes;
	private char acaoNoJogo;
	
	Scanner input = new Scanner(System.in);
	
	protected void setLinha() {
		this.linha = input.nextInt();
		if (linha > 9 || linha < 1) {
			setLinha();
		}
	}
	
	public int getLinha() {
		return this.linha;
	}
	
	protected void setColuna() {
		this.coluna = input.nextInt();
		if (this.coluna > 9 || this.coluna < 1) {
			setColuna();
		}
	}
	
	public int getColuna() {
		return this.coluna;
	}
	
	protected void setNome() {
		this.nomeDoJogador = input.next();
	}
	
	public String getNome() {
		return this.nomeDoJogador;
	}
	
	public void setOpcao() {
		this.opcoes = input.next().charAt(0);
		if (this.opcoes != '1' & this.opcoes != '2') {
			setOpcao();
		}
	}
	
	public int getOpcao() {
		return this.opcoes;
	}
	
	protected void setAcao() {
		this.acaoNoJogo = input.next().charAt(0);
		if(this.acaoNoJogo != 'a' & this.acaoNoJogo != 'A' & this.acaoNoJogo != 'b' & this.acaoNoJogo != 'B') {
			setAcao();
		}
	}
	
	public char getAcao() {
		return this.acaoNoJogo;
	}
}
