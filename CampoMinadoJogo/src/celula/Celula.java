package celula;

import java.util.ArrayList;

public abstract class Celula {
	
	public boolean fechada;
	public boolean vazia;
	public boolean marcada;
	public boolean mina;
	
	public ArrayList<Celula>campo;
	
	public Celula() {
		this.setFechada(true);
		this.campo = new ArrayList<>();
	}
	
	public void setFechada(boolean fechada) {
		this.fechada = fechada;
	}
	
	public boolean getFechada() {
		return this.fechada;
	}
	
	protected void setVazia(boolean vazia) {
		this.vazia = vazia;
	}
	
	public boolean getVazia() {
		return this.vazia;
	}
	
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	
	public boolean getMarcada() {
		return this.marcada;
	}
	
	protected void setMina(boolean mina) {
		this.mina = mina;
	}
	
	public boolean getMina() {
		return this.mina;
	}
	
	public abstract void abrirCelula();
	
	public abstract int numeroDeMinasVizinhas();
	
	public abstract String toString();
	
	public abstract void adicionarVizinhas(Celula v);
	
	public abstract boolean minar();
	
}
