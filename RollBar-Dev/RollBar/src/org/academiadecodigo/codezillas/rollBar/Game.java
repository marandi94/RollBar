package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.blocks.CheckColision;
import org.academiadecodigo.codezillas.rollBar.blocks.Direction;
import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.blocks.Direction;


public class Game {
    private Player[] players;
    private Grid gameBoard;
    private Engine gameEngine;
    private static GameBlock[][] matrix;
    private int delay;

    public Game(Player[] players) {
        this.players = players;
        this.gameBoard = new Grid();
        this.gameEngine = gameEngine;
        this.matrix = new GameBlock[gameBoard.getCols()][gameBoard.getRows()+1];
        this.delay = 1000;
        gameBoard.init();
    }

    public Player[] init(){ //returns Player[]

        return players;
    }

    public void start() throws InterruptedException{

           //start



        //thread things


        while(true) {
            players[0].setCube(BlockFactory.createCube(gameBoard));

            Cube activeCube = players[0].getCube();
            GameBlock activeBlock = activeCube.getGameBlock();
            players[0].setCurrentPiece(activeBlock);
            players[0].initKeyboard(activeCube);

            while (activeCube.getGameBlock().isActive()) {
                System.out.println("check 1");
                if (CheckColision.checkIfColides(activeBlock.getPosition(),Direction.DOWN)) {
                    setBlockIndex(activeBlock);
                    activeBlock.setActive(false);
                    System.out.println("check 2");
                }

                Thread.sleep(delay);
                activeCube.fall(activeBlock.fall());
                System.out.println("check final");

            }
        }
        //elevator music


    }

    public boolean isOccupied(GameBlock block){


            if (matrix[block.getCol()][block.getRow() + 1] != null){
                return true;
        }
            return false;

    }



    public Grid getGameBoard() {
        return gameBoard;
    }

    public GameBlock getBlock(int col, int row) {

        return matrix[col][row];

    }

    public void setBlockIndex(GameBlock active){

        this.matrix[active.getCol()][active.getRow()] = active;

    }

    public static GameBlock[][] getMatrix() {
        return matrix;
    }
}
