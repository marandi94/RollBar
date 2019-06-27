package org.academiadecodigo.codezillas.rollBar.blocks;

import org.academiadecodigo.codezillas.rollBar.Game;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Breaker extends GameBlock implements KeyboardHandler {

    public Breaker(BlockColor color, BlockType blockType, Position position) {
        super(color, blockType, position);
    }

    public boolean checkBreak(){
        return true;
    }

    public void search(Position position) {

        Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);

        if (Game.getMatrix()[position.getCol() + 1][position.getRow()] != null
                && Game.getMatrix()[position.getCol() + 1][position.getRow()].getColor().equals(this.getColor()) // relative search Right
                && !Game.getMatrix()[position.getCol() + 1][position.getRow()].isVisited()) {
            Position tempPosition = new Position(position.getCol() + 1, position.getRow(), Game.getGameBoard());
            search(tempPosition);
        }
        if (Game.getMatrix()[position.getCol()][position.getRow() + 1] != null
                && Game.getMatrix()[position.getCol()][position.getRow() + 1].getColor().equals(this.getColor()) // relative search Down
                && !Game.getMatrix()[position.getCol()][position.getRow() + 1].isVisited()) {
            Position tempPosition = new Position(position.getCol(), position.getRow() + 1, Game.getGameBoard());
            search(tempPosition);
        }
        if (Game.getMatrix()[position.getCol() - 1][position.getRow()] != null
                && Game.getMatrix()[position.getCol() - 1][position.getRow()].getColor().equals(this.getColor()) // relative search Left
                && !Game.getMatrix()[position.getCol() - 1][position.getRow()].isVisited()) {
            Position tempPosition = new Position(position.getCol() - 1, position.getRow(), Game.getGameBoard());
            search(tempPosition);
        }
        if (Game.getMatrix()[position.getCol()][position.getRow() - 1] != null
                && Game.getMatrix()[position.getCol()][position.getRow() - 1].getColor().equals(this.getColor()) // relative search UP
                && !Game.getMatrix()[position.getCol()][position.getRow() - 1].isVisited()) {
            Position tempPosition = new Position(position.getCol(), position.getRow() - 1, Game.getGameBoard());
            search(tempPosition);
        }
        System.out.println("KABOOOM");
    }

    public void search2(Position position){

        Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);

                GameBlock rightBlock = Game.getMatrix()[position.getCol()+1][position.getRow()];
                GameBlock leftBlock = Game.getMatrix()[position.getCol()-1][position.getRow()];
                GameBlock topBlock = Game.getMatrix()[position.getCol()][position.getRow()-1];
                GameBlock botBlock = Game.getMatrix()[position.getCol()][position.getRow()+1];

        if(position.getCol() < 9
                && rightBlock != null
                && rightBlock.getColor().equals(this.getColor()) // relative search Right
                && !rightBlock.isVisited()){
            Position tempPosition = new Position(position.getCol()+1,position.getRow(),Game.getGameBoard());
            search2(tempPosition);
        }
        if (position.getRow() < 16
                && botBlock != null
                && botBlock.getColor().equals(this.getColor()) // relative search Down
                && !botBlock.isVisited()){ // acho
            Position tempPosition = new Position(position.getCol(),position.getRow()+1,Game.getGameBoard());
            search2(tempPosition);
        }
        if (position.getCol() > 0
                && leftBlock != null
                && leftBlock.getColor().equals(this.getColor()) // relative search Left
                && !leftBlock.isVisited()) {
            Position tempPosition = new Position(position.getCol() - 1, position.getRow(), Game.getGameBoard());
            search2(tempPosition);
        }
        if (position.getRow() > 0
                && topBlock != null
                && topBlock.getColor().equals(this.getColor()) // relative search UP
                && topBlock.isVisited()){
            Position tempPosition = new Position(position.getCol(), position.getRow()-1, Game.getGameBoard());
            search2(tempPosition);
        }

        System.out.println("BOOOOOOOOOOOMMMMMMMMMMMMM");
        //Game.getMatrix()[position.getCol()][position.getRow()].delete();
        return;
        //DESTROY HERE AND RETURN

    }
        @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
