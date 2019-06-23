package org.academiadecodigo.codezillas.rollBar.blocks;


import org.academiadecodigo.codezillas.rollBar.Game;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;

public class CheckColision {
    private static GameBlock[][] matrix = Game.getMatrix();

    public static boolean checkIfColides(Position position, Direction dir){ // podemos retornar uma position e o bloco nao mexer depois do check

        switch (dir){
            case LEFT:

                Position tempPositionLeft = new Position(position.getCol()-1,position.getRow(),position.getGrid());
                if(tempPositionLeft.getCol() == -1 ){
                    return true;
                }
                if(matrix[position.getCol()-1][position.getRow()] != null){
                    return true;
                }
                return false;

            case DOWN:

                Position tempPositionDown = new Position(position.getCol(),position.getRow()+1,position.getGrid());
                if(tempPositionDown.getRow() == 17 ){
                    return true;
                }
                if(matrix[position.getCol()][position.getRow()+1] != null){
                    return true;
                }
                return false;

            case RIGHT:

                Position tempPositionRight = new Position(position.getCol()+1,position.getRow(),position.getGrid());
                if(tempPositionRight.getCol() == 9 ){
                    return true;
                }
                if(matrix[position.getCol()+1][position.getRow()] != null){
                    return true;
                }
                return false;

                default:
                    System.out.println("Check colision checkcolision shit happened");
                    return true;
        }
    }
}
