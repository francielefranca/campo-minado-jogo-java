package gui;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {

	private int bound = Game.GRIDSIZE * Game.GRIDSIZE;

    private boolean escolhida = false;

    private ArrayList<Integer> bombas = new ArrayList<Integer>();

    public static ArrayList<JCell> jCellGrid = new ArrayList<JCell>();

    public Grid(GridLayout g, Handler h) {
        super(g);
        criarCelulas(h);
        adicionarCelulas();
    }

    public void criarCelulas(Handler h) {
        for(int i = 1; i <= Game.MINECOUNT; i++) {
            while(!escolhida) {
                int minePosition = (int) (Math.random() * bound);
                if (!bombas.contains(minePosition)) {
                	bombas.add(minePosition);
                    escolhida = true;
                }
            }
            escolhida = false;
        }

        for(int i = 0; i < bound; i++) {
            if(bombas.contains(i)) {
                jCellGrid.add(new JCell(1, i, false, false, h));
            } else if(i % Game.GRIDSIZE == 0){
                if(bombas.contains(i - Game.GRIDSIZE) ||
                		bombas.contains(i - Game.GRIDSIZE + 1) ||
                        bombas.contains(i + 1) ||
                        bombas.contains(i + Game.GRIDSIZE) ||
                        bombas.contains(i + Game.GRIDSIZE + 1)) {
                    jCellGrid.add(new JCell(2, i, false, false, h));
                } else {
                    jCellGrid.add(new JCell(0, i, false, false, h));
                }
            } else if(i % Game.GRIDSIZE == Game.GRIDSIZE - 1){
                if(bombas.contains(i - Game.GRIDSIZE - 1) ||
                		bombas.contains(i - Game.GRIDSIZE) ||
                		bombas.contains(i - 1) ||
                		bombas.contains(i + Game.GRIDSIZE - 1) ||
                		bombas.contains(i + Game.GRIDSIZE)) {
                    jCellGrid.add(new JCell(2, i, false, false, h));
                } else {
                    jCellGrid.add(new JCell(0, i, false, false, h));
                }
            }else {
                if(bombas.contains(i - Game.GRIDSIZE - 1) ||
                		bombas.contains(i - Game.GRIDSIZE) ||
                        bombas.contains(i - Game.GRIDSIZE + 1) ||
                        bombas.contains(i - 1) ||
                        bombas.contains(i + 1) ||
                        bombas.contains(i + Game.GRIDSIZE - 1) ||
                        bombas.contains(i + Game.GRIDSIZE) ||
                        bombas.contains(i + Game.GRIDSIZE + 1)) {
                    jCellGrid.add(new JCell(2, i, false, false, h));
                } else {
                    jCellGrid.add(new JCell(0, i, false, false, h));
                }
            }
        }
    }

    private void adicionarCelulas() {
        for(int i = 0; i < jCellGrid.size(); i++) {
            add(jCellGrid.get(i));
        }
    }
}
