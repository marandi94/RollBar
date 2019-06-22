package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.blocks.CheckColision;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.codezillas.rollBar.blocks.Block;

public class Main {
    public static void main(String[] args) {
        /*
         Grid grid = new Grid();

        grid.init();
        Block block = (Block) BlockFactory.create();
        CheckColision colision = new CheckColision();
        colision.setAllBlocks(BlockFactory.getAllBlocks());

        Cube test = new Cube(grid, block);

        Player one = new Player();

        one.initKeyboard(test);
*/
        Player[] players = new Player[2];
        players[0] = new Player();
        Game game = new Game(players);
        try {game.start();
        }catch (InterruptedException inter){
            System.out.println("ok, great");
        }

    }
}