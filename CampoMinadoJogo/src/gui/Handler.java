package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Handler {

	private ArrayList<JCell> current = new ArrayList<JCell>();
	private ArrayList<JCell> queue = new ArrayList<JCell>();
	
	private static int bandeirasCell = 0;
	
	ImageIcon FECHADA = new ImageIcon("figuras\\capa.png");
	ImageIcon BANDEIRA = new ImageIcon("figuras\\bandeira.png");
	
	/* ImageIcon tImageIcon = null;
     ImageIcon pitImageIcon = null;
     ImageIcon lossImageIcon = null;
     ImageIcon oneImageIcon = null;
     ImageIcon twoImageIcon = null;
     ImageIcon threeImageIcon = null;
     ImageIcon fourImageIcon = null;
     ImageIcon fiveImageIcon = null;
     ImageIcon sixImageIcon = null;
     ImageIcon sevenImageIcon = null;
     ImageIcon eightImageIcon = null;
     ImageIcon flaggedCellImageIcon = null;*/
     
     
    /* public ImageIcon getScaledImage(String imageString) {
         ImageIcon imageIcon = new ImageIcon(imageString);
         Image image = imageIcon.getImage(); 
         Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
         imageIcon = new ImageIcon(newimg);
         return imageIcon;
      }*/
     
     
     public void loadMinesweeperImages() {
         tImageIcon = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\capa.png");
         pitImageIcon = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\bomba.png");
         lossImageIcon = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero0.png");
         oneImageIcon = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero1.png");
         twoImageIcon = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero2.png");
         threeImageIcon  = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero3.png");
         fourImageIcon  = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero4.png");
         fiveImageIcon = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero5.png");
        sixImageIcon  = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero6.png");
        sevenImageIcon  = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero7.png");
        eightImageIcon  = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\numero8.png");
        flaggedCellImageIcon  = getScaledImage("C:\\Users\\Joâo\\Desktop\\figuras\\bandeira.png");
        
     }
	
    
     

	public void click(JCell jCell) {
        	loadMinesweeperImages();

	        int celulasAbertas = 0;
	        if(!jCell.comBandeira()) {
	        	jCell.setEnabled(false);
	        	jCell.setAberta(true);

	            int posicao = jCell.getPosicao();
	            if(jCell.getType() == 0) {
	                if(posicao < Game.GRIDSIZE) {
	                    if(posicao % Game.GRIDSIZE == 0) {
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)));
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE + 1)));
	                        queue.add(Grid.jCellGrid.get((posicao + 1)));
	                    } else if(posicao % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)));
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE - 1)));
	                        queue.add(Grid.jCellGrid.get((posicao - 1)));
	                    } else {
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)));
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE + 1)));
	                        queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE - 1)));
	                        queue.add(Grid.jCellGrid.get((posicao + 1)));
	                        queue.add(Grid.jCellGrid.get((posicao - 1)));
	                    }
	                } else if(posicao >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
	                    if(posicao % Game.GRIDSIZE == 0) {
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)));
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE + 1)));
	                        queue.add(Grid.jCellGrid.get((posicao + 1)));
	                    } else if(posicao % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)));
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE - 1)));
	                        queue.add(Grid.jCellGrid.get((posicao - 1)));
	                    } else {
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)));
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE + 1)));
	                        queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE - 1)));
	                        queue.add(Grid.jCellGrid.get((posicao + 1)));
	                        queue.add(Grid.jCellGrid.get((posicao - 1)));
	                    }
	                } else if(posicao % Game.GRIDSIZE == 0) {
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)));
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE + 1)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE + 1)));
	                    queue.add(Grid.jCellGrid.get((posicao + 1)));
	                } else if(posicao % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)));
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE - 1)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE - 1)));
	                    queue.add(Grid.jCellGrid.get((posicao - 1)));
	                } else {
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)));
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE - 1)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE - 1)));
	                    queue.add(Grid.jCellGrid.get((posicao - Game.GRIDSIZE + 1)));
	                    queue.add(Grid.jCellGrid.get((posicao + Game.GRIDSIZE + 1)));
	                    queue.add(Grid.jCellGrid.get((posicao - 1)));
	                    queue.add(Grid.jCellGrid.get((posicao + 1)));
	                }
	            } else if(jCell.getType() == 2) {
	                int dangerCount = 0;
	                if(posicao < Game.GRIDSIZE) {
	                    if(posicao % Game.GRIDSIZE == 0) {
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE + 1).getType() == 1) dangerCount++; 
	                        if(Grid.jCellGrid.get(posicao + 1).getType() == 1) dangerCount++;
	                    } else if(posicao % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - 1).getType() == 1) dangerCount++;
	                    } else {
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - 1).getType() == 1) dangerCount++;
	                        System.out.println(dangerCount);
	                    }
	                } else if(posicao >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
	                    if(posicao % Game.GRIDSIZE == 0) {
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + 1).getType() == 1) dangerCount++;
	                    } else if(posicao % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - 1).getType() == 1) dangerCount++;
	                    } else {
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao + 1).getType() == 1) dangerCount++;
	                        if(Grid.jCellGrid.get(posicao - 1).getType() == 1) dangerCount++;
	                    }
	                } else if(posicao % Game.GRIDSIZE == 0) {
	                    if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get(posicao - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get(posicao + Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get(posicao + 1).getType() == 1) dangerCount++;
	                } else if(posicao % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
	                    if(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao - Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao + Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao - 1)).getType() == 1) dangerCount++;
	                } else {
	                    if(Grid.jCellGrid.get((posicao - Game.GRIDSIZE)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao + Game.GRIDSIZE)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao - Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao + Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao - Game.GRIDSIZE + 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao + Game.GRIDSIZE + 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao - 1)).getType() == 1) dangerCount++;
	                    if(Grid.jCellGrid.get((posicao + 1)).getType() == 1) dangerCount++;
	                }
	                jCell.setText(String.valueOf(dangerCount));
	            } else if(jCell.getType() == 1) {
	                for(int x = 0; x < Grid.jCellGrid.size(); x++) {
	                    Grid.jCellGrid.get(x).setEnabled(false);
	                    Grid.jCellGrid.get(x).setText("");
	                    if(Grid.jCellGrid.get(x).getType() == 1) {Grid.jCellGrid.get(x).setText("X");}
	                }
	                jCell.setText("*");
	            }  

	            for(int x = 0; x < queue.size(); x++) {
	                if(!queue.get(x).isAberta()) {
	                    current.add(queue.get(x));
	                    queue.get(x).setAberta(true);
	                }
	            }
	            queue.clear();
	            while(!current.isEmpty()) {
	                JCell temp = current.get(0);
	                current.remove(0);
	                temp.clickButton();
	            }

	            for(int x = 0; x < Grid.jCellGrid.size(); x++) {
	                if(Grid.jCellGrid.get(x).isAberta()) {
	                	celulasAbertas++;
	                }
	            }

	            if(celulasAbertas == Grid.jCellGrid.size() - Game.MINECOUNT) {
	                for(int x = 0; x < Grid.jCellGrid.size(); x++) {
	                    if(Grid.jCellGrid.get(x).getType() == 1) {
	                        Grid.jCellGrid.get(x).setEnabled(false);
	                        Grid.jCellGrid.get(x).setIcon(pitImageIcon);
	                    } else {
	                        Grid.jCellGrid.get(x).setEnabled(false);
	                        Grid.jCellGrid.get(x).setIcon(fiveImageIcon);
	                    }
	                }
	            }
	        }   
	    }

	    public void rightClick(JCell jCell) {
            loadMinesweeperImages();

	        if(!jCell.isAberta()) {
	            if(!jCell.comBandeira()) {
	            	jCell.setComBandeira(true);
	                jCell.setText("B");
	                bandeirasCell++;
	                Janela.update(bandeirasCell);
	            } else {
	            	jCell.setComBandeira(false);
	            	jCell.setText("");
	            	bandeirasCell--;
	                Janela.update(bandeirasCell);
	            }
	        }
	    }
	    
}
