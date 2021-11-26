package jogador;
import java.util.Scanner;

public class InteracaoComUsuario {
	
	private int linhaDeEntrada;
	private int colunaDeEntrada;
	private String nomeDoJogador;
	private char opcao;
	private char acaoNoJogo;
	
	Scanner input = new Scanner(System.in);
	
	protected void setLinha(int linha) {
		this.linhaDeEntrada = input.nextInt();
		if ((linhaDeEntrada > linha) || (linhaDeEntrada < 1)) {
			setLinha(linha);
		}
	}
	
	public int getLinha() {
		return this.linhaDeEntrada -1;
	}
	
	protected void setColuna(int coluna) {
		this.colunaDeEntrada = input.nextInt();
		if ((this.colunaDeEntrada > coluna) || (this.colunaDeEntrada < 1)) {
			setColuna(coluna);
		}
	}
	
	public int getColuna() {
		return this.colunaDeEntrada;
	}
	
	protected void setNome() {
		this.nomeDoJogador = input.next();
	}
	
	public String getNome() {
		return this.nomeDoJogador;
	}
	
	protected void setOpcao() {
		this.opcao = input.next().charAt(0);
		if ((this.opcao != '1') & (this.opcao != '2')) {
			setOpcao();
		}
	}
	
	public char getOpcao() {
		return this.opcao;
	}
	
	protected void setAcao() {//verificacao se o que foi digitado pelo jogador na escolha das acoes eh valido
		this.acaoNoJogo = input.next().charAt(0);
		if((this.acaoNoJogo != 'a' & this.acaoNoJogo != 'A') & (this.acaoNoJogo != 'b' & this.acaoNoJogo != 'B')) {
			System.out.print("Escolha uma ação existente: ");
			setAcao();
		}
	}
	
	public char getAcao() {
		return this.acaoNoJogo;
	}
}
