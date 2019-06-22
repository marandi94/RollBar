package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;

public class BlockFactory {
    private static GameBlock[] allBlocks = new GameBlock[20];
    private static int counter;
    private Grid grid;

    public BlockFactory(Grid grid){
        this.grid = grid;
    }

    public  GameBlock chooseBlockType(){
        GameBlock gameBlocks;

      /*  if (random <= 3){
            gameBlocks = new Breaker();
            return gameBlocks;
        }*/
        Position initialPos = new Position(4,0,grid );
        gameBlocks = new Block(chooseColorBlock(), BlockType.BLOCK, initialPos);
        allBlocks[counter] = gameBlocks;
        counter++;

        return gameBlocks;
        
    }



    public static Color chooseColorBlock(){

        int random = (int) (Math.random() * Color.values().length);

        switch (random){
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            default:
                System.out.println("Block factory // choose color block // shit happened !!");
                return Color.RED;
        }


    }

    public void create(){



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
