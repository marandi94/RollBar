package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.blocks.CheckColision;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.codezillas.rollBar.blocks.Block;

public class Main {
    public static void main(String[] args) {

         Grid grid = new Grid();

         BlockFactory factory = new BlockFactory(grid);

        grid.init();
        Block block = (Block) factory.chooseBlockType();
        CheckColision colision = new CheckColision();
        colision.setAllBlocks(BlockFactory.getAllBlocks());

        Cube test = new Cube(grid, block);

        Player one = new Player();

        one.initKeyboard(test);


    }
}