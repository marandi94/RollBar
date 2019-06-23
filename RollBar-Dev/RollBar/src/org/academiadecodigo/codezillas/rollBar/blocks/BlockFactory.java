package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.Game;
import org.academiadecodigo.codezillas.rollBar.PuyoBreaker;
import org.academiadecodigo.codezillas.rollBar.PuyoRectangle;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;


public abstract class BlockFactory {
    private static GameBlock[] allBlocks = new GameBlock[20];
    private static int counter;
    private static Grid grid;

    public BlockFactory() {

    }

    public static Cube createCube(Grid grid) {

        return new Cube(grid, create());

    }

    private static BlockType chooseBlockType() {

        int random = (int) Math.floor(Math.random() * 100);
        if (random <= 50) {
            return BlockType.BREAKER;
        }
        return BlockType.BLOCK;
    }

    private static BlockColor chooseColorBlock() {

        int random = (int) (Math.random() * BlockColor.values().length);

        switch (random) {
            case 0:
                return BlockColor.RED;
            case 1:
                return BlockColor.GREEN;
            case 2:
                return BlockColor.BLUE;
            case 3:
                return BlockColor.YELLOW;
            default:
                System.out.println("Block factory // choose color block // shit happened !!");
                return BlockColor.RED;
        }


    }

    public static GameBlock create() {

        BlockType blockType = chooseBlockType();
        BlockType blockType1 = chooseBlockType();
        GameBlock master;
        GameBlock slave;
        Position initialPos = new Position(4, 1, grid);
        Position initialPos1 = new Position(4, 0, grid);

        if (blockType == BlockType.BREAKER) {
            master = new Breaker(chooseColorBlock(), blockType, initialPos);
        }else {
            master = new Block(chooseColorBlock(), blockType, initialPos);
        }

        if(blockType1 == BlockType.BREAKER){
            slave = new Breaker(chooseColorBlock(), blockType1, initialPos1);
        } else {
            slave = new Block(chooseColorBlock(), blockType1, initialPos1);
        }

        System.out.println("here i am!");
        master.setSlave(slave);
        counter++;
        return master;
    }


}

