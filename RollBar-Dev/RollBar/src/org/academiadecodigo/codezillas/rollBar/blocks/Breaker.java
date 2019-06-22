package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;

public class Breaker extends GameBlock {

    public Breaker(BlockColor color, BlockType blockType, Position position) {
        super(color, blockType, position);
    }

    public boolean checkBreak(){
        return true;
    }



}
