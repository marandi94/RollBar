package org.academiadecodigo.codezillas.rollBar.blocks;

public abstract class GameBlocks implements Movable {

    private Color color;
    private boolean destroyed;
    int col;
    int row;


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
