package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;


public abstract class GameBlock implements Movable {

    private BlockColor color;
    private Grid grid;
    private Position position;
    private BlockType blockType;
    private boolean destroyed;
    private boolean active = true;
    private Cube blockPosition;



    public GameBlock(BlockColor color, BlockType blockType, Position position){
        this.position = position;
        this.color = color;
        this.blockType = blockType;

    }

    public Position getPosition() {
        return position;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isActive(){
        return active;
    }
    public void setActive(boolean state){
        active = state;
    }

    public boolean move(Direction direction){

        switch (direction){
            case RIGHT:
                if(position.getCheckColision().checkIfColides(position,Direction.RIGHT)){
                    return false;

                  }
                moveRight();
                return true;
            case LEFT:
                if(position.getCheckColision().checkIfColides(position,Direction.LEFT)){
                   return false;
                 }
                moveLeft();
                return true;
        }

        System.out.println("GameBlock/move shit happened!");
        return false;
    }


    @Override
    public void moveLeft() {
        position.setCol(position.getCol() - 1);
    }

    @Override
    public void moveRight() {
        position.setCol(position.getCol() + 1);
    }

    @Override
    public void drop() {
        position.setRow(position.getRow() + 1);
    }

    public void setDestroyed(){
        destroyed = true;
    }

    @Override
    public void flip(GameBlock gameBlock) {
            //trocar por swap!!!!
    }






}
