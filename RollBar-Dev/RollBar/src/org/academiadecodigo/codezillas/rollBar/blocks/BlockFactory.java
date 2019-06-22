package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.Game;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;


public abstract class BlockFactory {
    private static GameBlock[] allBlocks = new GameBlock[20];
    private static int counter;
    private static Grid grid;

    public BlockFactory(){

    }

    public static Cube createCube(Grid grid){

        return new Cube(grid, create());

    }

    private static BlockType chooseBlockType(){

        int random =(int) Math.floor(Math.random()*100);
        if (random <= 3) {
            return BlockType.BREAKER;
        }
        return BlockType.BLOCK;
    }

    private static BlockColor chooseColorBlock(){

        int random = (int) (Math.random() * BlockColor.values().length);

        switch (random){
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

    public static GameBlock create(){

        BlockType blockType = chooseBlockType();
        Position initialPos = new Position(4,0,grid);

        if (blockType == BlockType.BLOCK){
            GameBlock block = new Block(chooseColorBlock(),blockType,initialPos);
            allBlocks[counter] = block;
            counter++;
            return block;
        }
        GameBlock breaker = new Breaker(chooseColorBlock(),blockType,initialPos);
        allBlocks[counter] = breaker;
        counter++;
        return breaker;
    }



    public static GameBlock[] getAllBlocks() {
        return allBlocks;
    }

    /*
    public Block makeBlock(){

        return ;
    }

    public Breaker makeBreaker(){
        return ;
    }

    public Block pushBlocks(int amount){  // posiçao linha no topo do screen
        return ;
    }
*/

}
