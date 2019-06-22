package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Breaker extends GameBlock {
    private Ellipse ellipse;

    public Breaker(BlockColor color, BlockType blockType, Position position) {
        super(color, blockType, position);
    }

    public boolean checkBreak(){
        return true;
    }



}
