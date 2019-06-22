package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.codezillas.rollBar.blocks.Block;

public class Main {
    public static void main(String[] args) {

         Grid grid = new Grid();

        grid.init();
        Block block = (Block) BlockFactory.chooseBlockType();

        Cube test = new Cube(grid, block);

        Player one = new Player();

        one.initKeyboard(test);


    }
}