package gui;

import javax.swing.JPanel;

public class JCampo extends JPanel {

	protected JCelula jCelula;
	protected int linha;
	protected int coluna;
	
	public JCampo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public JCampo(JCelula jCelula) {
		this.jCelula = jCelula;
		this.linha = jCelula.getCelula().getLinha();
		this.coluna = jCelula.getCelula().getColuna();
		this.add(jCelula);
		
		}

}
