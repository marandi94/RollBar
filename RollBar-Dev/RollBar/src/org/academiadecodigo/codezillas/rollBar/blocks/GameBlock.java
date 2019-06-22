package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public abstract class GameBlock implements Movable, KeyboardHandler {

    private Color color;
    private Grid grid;
    private Position position;
    private BlockType blockType;
    private boolean destroyed;
    private boolean active;


    public GameBlock(){

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
