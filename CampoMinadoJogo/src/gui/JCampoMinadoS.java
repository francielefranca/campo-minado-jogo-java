package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import campoMinado.Tabuleiro;

public class JCampoMinadoS {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCampoMinadoS window = new JCampoMinadoS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		new JCampoMinado();

		
	}

	/**
	 * Create the application.
	 */
	
	

}
