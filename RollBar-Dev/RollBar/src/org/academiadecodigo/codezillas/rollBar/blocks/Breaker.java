package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class Breaker extends GameBlock {

    public Breaker(Color color, BlockType blockType, Position position) {
        super(color, blockType, position);
    }

    public boolean checkBreak(){

        return true;
    }



}
