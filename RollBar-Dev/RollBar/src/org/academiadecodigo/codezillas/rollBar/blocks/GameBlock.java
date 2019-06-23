package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public abstract class GameBlock implements Movable, KeyboardHandler {

    private BlockColor color;
    private Grid grid;
    private Position position;
    private BlockType blockType;
    private boolean destroyed;
    private boolean active = true;
    private GameBlock slave;
    private boolean visited;




    public GameBlock(BlockColor color, BlockType blockType, Position position, GameBlock slave){
        this.position = position;
        this.color = color;
        this.blockType = blockType;
        this.slave = slave;

    }

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
                slave.moveRight();
                System.out.println("Master" + this.getPosition().getCol() + " " + this.getPosition().getRow());
                System.out.println("Slave" + slave.getPosition().getCol() + " " + slave.getPosition().getRow());
                return true;
            case LEFT:
                if(position.getCheckColision().checkIfColides(position,Direction.LEFT)){
                   return false;
                 }
                moveLeft();
                slave.moveLeft();
                System.out.println("Master" + this.getPosition().getCol() + " " + this.getPosition().getRow());
                System.out.println("Slave" + slave.getPosition().getCol() + " " + slave.getPosition().getRow());
                return true;
        }

        System.out.println("GameBlock/move shit happened!");
        return false;
    }


    public boolean fall() {
        if (position.getCheckColision().checkIfColides(position,Direction.DOWN)){
            setActive(false); // desativar bloco aqui??
            slave.setActive(false);
            System.out.println("Master" + this.getPosition().getCol() + " " + this.getPosition().getRow());
            System.out.println("Slave" + slave.getPosition().getCol() + " " + slave.getPosition().getRow());
            return false;
        }
        position.setRow(position.getRow() + 1);
        slave.drop();
        System.out.println("Master" + this.getPosition().getCol() + " " + this.getPosition().getRow());
        System.out.println("Slave" + slave.getPosition().getCol() + " " + slave.getPosition().getRow());
        return true;
    }

    @Override
    public void moveLeft() {

        if (position.getCheckColision().checkIfColides(position,Direction.LEFT)) {
            return;

        }
        position.setCol(position.getCol() - 1);
    }

    @Override
    public void moveRight() {
        if (position.getCheckColision().checkIfColides(position,Direction.RIGHT)) {
           return;
        }
        position.setCol(position.getCol() + 1);
    }

    @Override
    public void drop() {
        if (position.getCheckColision().checkIfColides(position, Direction.DOWN)){
            return;
        }
        position.setRow(position.getRow() + 1);
        // Feature space bar drops the piece
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


    public void setSlave(GameBlock slave) {
        this.slave = slave;
    }

    public GameBlock getSlave() {
        return slave;
    }

    public BlockColor getColor() {
        return color;
    }

    public void setColor(BlockColor color) {
        this.color = color;
    }

    public BlockType getBlockType(){
        return blockType;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
