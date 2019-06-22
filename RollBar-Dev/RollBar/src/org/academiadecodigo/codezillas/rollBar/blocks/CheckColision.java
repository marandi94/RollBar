package org.academiadecodigo.codezillas.rollBar.blocks;


import org.academiadecodigo.codezillas.rollBar.Game;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;

public class CheckColision {
    private GameBlock[] allBlocks = BlockFactory.getAllBlocks();

    public boolean checkIfColides(Position position, Direction dir){ // podemos retornar uma position e o bloco nao mexer depois do check

        switch (dir){
            case LEFT:
                Position tempPositionLeft = new Position(4,4,position.getGrid());
                tempPositionLeft.setCol(position.getCol()-1);
                tempPositionLeft.setRow(position.getRow());
                if(tempPositionLeft.getCol() == -1 ){
                    return true;
                }
                for (GameBlock block: allBlocks){
                    if (block.getPosition() == tempPositionLeft){
                        return true;       //se retornarmos a position ele nao mexe

                    }
                    return false; // se retornarmos a temp position ele mexe
                }
                break;
            case DOWN:
                Position tempPositionDown = new Position(4,4,position.getGrid());
                tempPositionDown.setCol(position.getCol());
                tempPositionDown.setRow(position.getRow()+1);
                if(tempPositionDown.getRow() == 16 ){
                    return true;
                }
                for (GameBlock block: allBlocks){
                    if (block.getPosition() == tempPositionDown){
                        return true;       //se retornarmos a position ele nao mexe

                    }
                    return false; // se retornarmos a temp position ele mexe
                }

                break;
            case RIGHT:
                Position tempPositionRight = new Position(4,4,position.getGrid());
                tempPositionRight.setCol(position.getCol()+1);
                tempPositionRight.setRow(position.getRow());
                if(tempPositionRight.getCol() == 9 ){
                    return true;
                }
                for (GameBlock block: allBlocks){
                    if (block.getPosition() == tempPositionRight){
                        return true;       //se retornarmos a position ele nao mexe

                    }
                    return false; // se retornarmos a temp position ele mexe
                }

                break;
                default:
                    System.out.println("Check colision checkcolision shit happened");
                    return true;
        }


        System.out.println("Check colision checkcolision shit happened");
        return true;
    }

    public void setAllBlocks(GameBlock[] allBlocks) {
        this.allBlocks = allBlocks;
    }
}
