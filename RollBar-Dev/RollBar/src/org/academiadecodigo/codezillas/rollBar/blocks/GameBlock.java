package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.Game;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public abstract class GameBlock implements Movable {

    private Color color;
    private Grid grid;
    private Position position;
    private BlockType blockType;
    private boolean destroyed;
    private boolean active;
    private Cube blockPosition;



    public GameBlock(Color color, BlockType blockType, Position position){
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

    public void move(Direction direction){

        switch (direction){
            case RIGHT:
                if(position.getCheckColision().checkIfColides(position,Direction.RIGHT)){
                    break;
                  }
                moveRight();
                break;
            case LEFT:
                if(position.getCheckColision().checkIfColides(position,Direction.LEFT)){
                   break;
                 }
                moveLeft();
                break;
        }
    }


    public void fall() {
        if (position.getCheckColision().checkIfColides(position,Direction.DOWN)){
            return;
        }
        position.setRow(position.getRow() + 1);
        return;
    }

    @Override
    public void moveLeft() {

        if (position.getCheckColision().checkIfColides(position,Direction.LEFT)) {
            return;

        }
        position.setCol(position.getCol() - 1);
        return;
    }

    @Override
    public void moveRight() {
        if (position.getCheckColision().checkIfColides(position,Direction.RIGHT)) {
           return;
        }
        position.setCol(position.getCol() + 1);
        return;
    }





    @Override
    public void drop() {
        // Feature space bar drops the piece
    }

    public void setDestroyed(){
        destroyed = true;
    }

    @Override
    public void flip(GameBlock gameBlock) {
            //trocar por swap!!!!
    }






}
