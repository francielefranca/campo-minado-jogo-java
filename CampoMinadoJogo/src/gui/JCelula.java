package gui;

import javax.swing.JPanel;

import celulas.Celula;

public class JCelula extends JPanel {

	protected Celula celula;
	
	public JCelula(Celula celula) {
		this.celula = celula;
	}
	
	public Celula getCelula() {
		return this.celula;
	}

}
