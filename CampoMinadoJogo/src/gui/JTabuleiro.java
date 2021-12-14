package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import campoMinado.Tabuleiro;
import celulas.Celula;

public class JTabuleiro extends JPanel {

protected Tabuleiro tabuleiro;
	
	
	public JTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
	}
	
	public void desenhaTabuleiro() {
		this.removeAll();
		this.setLayout(new GridLayout(9,9));
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				JCampo jCampo;
				Celula celula = this.tabuleiro.getCelula(i, j);
				if(celula == null) {
					jCampo = new JCampo(i,j);
				}else {
					jCampo = new JCampo(new JCelula(celula));
				}
			}
		}
	}
	

}
