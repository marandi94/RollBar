package org.academiadecodigo.codezillas.rollBar.blocks;

public class BlockFactory {



    public static GameBlock chooseBlockType(){
        GameBlock gameBlocks;
        int random = (int) (Math.random() * 101);
        BlockType blockType = BlockType.values()[random];
        if (random <= 3){
            gameBlocks = new Breaker();
            return gameBlocks;
        }
        gameBlocks = new Block();

        return gameBlocks;
        
    }



    public static Color chooseColorBlock(GameBlock gameBlocks){

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
