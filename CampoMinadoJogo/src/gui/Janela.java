package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {

	private static JFrame frame;
	private static String title;
	
	
	
	public Janela(int width, int height, int gridSize, String title, Game game, Handler handler) {
		Janela.title = title;
		frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));		
		frame.setMaximumSize(new Dimension(width, height));		
		frame.setResizable(false);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setMinimumSize(new Dimension(width, height));		
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new Grid(new GridLayout(gridSize, gridSize), handler);
		
		frame.setContentPane(panel);
		frame.pack();
		
		frame.setVisible(true);
	}

	public static void update(int comBandeira) {
		frame.setTitle(title + "Minas:" + Game.MINECOUNT + " - Bandeiras:" + comBandeira);
	}
	
}
