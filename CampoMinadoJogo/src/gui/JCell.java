package gui;

import javax.swing.*;
import java.awt.event.*;

public class JCell extends JButton {
	
	private int type;
	private int posicao;
	private boolean aberta;
	private boolean comBandeira;
	private Handler handler;
	
	public JCell(int type, int posicao, boolean aberta, boolean comBandeira, Handler handler) {
		this.type = type;
		this.posicao = posicao;
		this.aberta = aberta;
		this.comBandeira = comBandeira;
		this.handler = handler;
		
		addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					rightClickButton();
				}else {
					clickButton();
				}
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	public int getType() {
		//TYPES -- 0: Vazia, 1: Bomba, 2: Vizinha
		return type;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
	
	public boolean comBandeira() {
		return comBandeira;
	}
	
	public void setComBandeira(boolean comBandeira) {
		this.comBandeira = comBandeira;
	}
	
	public void clickButton() {
		handler.click(this);
	}
	
	public void rightClickButton() {
		handler.rightClick(this);
	}
}
