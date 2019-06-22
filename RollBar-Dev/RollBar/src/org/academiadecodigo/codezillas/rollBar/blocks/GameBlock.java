package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.GridRollBar;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public abstract class GameBlock implements Movable {

    private Color color;
    private GridRollBar grid;
    private Position position;
    private KeyboardHandler keyboardHandler;
    private BlockType blockType;
    private boolean destroyed;
    private boolean active;


    public GameBlock(Color color, BlockType blockType){

    }

    public GridPosition getPosition() {
        return position;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isActive(){
        return active;
    }

    public void move(Direction direction){


    }

    public void fall(){

    }








    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void drop() {

    }

    public void setDestroyed(){
        destroyed = true;
    }

    @Override
    public void flip() {

    }




}
