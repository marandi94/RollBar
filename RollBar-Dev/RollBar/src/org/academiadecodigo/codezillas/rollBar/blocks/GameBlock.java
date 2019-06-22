package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.ColorMapper;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;


public abstract class GameBlock implements Movable {

    private BlockColor color;
    private Grid grid;
    private Position position;
    private BlockType blockType;
    private boolean destroyed;
    private boolean active = true;


    public GameBlock(BlockColor color, BlockType blockType, Position position){
        this.grid = grid;
        this.position = new Position(4, 0, grid);

        this.blockType = blockType;


    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        if (!isActive()){
            return;
        }
        switch (key) {
            case KeyboardEvent.KEY_LEFT:
                if (move(Direction.LEFT)) {
                    translate(-grid.getCellSize(), 0);
                    System.out.println("GAMEBlock" + gameBlock.getPosition().getCol() + " " + gameBlock.getPosition().getRow());
                    break;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (move(Direction.RIGHT)) {
                    cube.translate(grid.getCellSize(), 0);
                    System.out.println("GAMEBlock" + gameBlock.getPosition().getCol() + " " + getPosition().getRow());
                    break;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (fall()) {

                    System.out.println("GAMEBlock" + getPosition().getCol() + " " + getPosition().getRow());
                    break;
                }
        }
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

    public int getCol(){

        return position.getCol();

    }

    public int getRow(){

       return position.getRow();

    }

    public void setColor(BlockColor color){

        color.equals(ColorMapper.getColor(color));

    }




}
