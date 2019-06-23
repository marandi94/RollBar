package org.academiadecodigo.codezillas.rollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.graphics.Cube;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;


public class Game {
    private Player[] players;
    private Grid gameBoard;
    private Engine gameEngine;
    private GameBlock[][] matrix;
    private int delay;
    private GameBlock[] activePiece = new GameBlock[2];

    public Game(Player[] players) {
        this.players = players;
        this.gameBoard = new Grid();
        this.gameEngine = gameEngine;
        this.matrix = new GameBlock[gameBoard.getCols()][gameBoard.getRows()];
        this.delay = 300;
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

            players[0].initKeyboard(activeCube);

            while (activeCube.getGameBlock().isActive()) {


                if (isOccupied(activeBlock)) {
                    setBlockIndex(activeBlock);
                    activeBlock.setActive(false);
                    break;
                }

                Thread.sleep(delay);
                activeCube.fall(activeBlock.fall());

            }
            throw new InterruptedException();
        }
        //elevator music


    }

    public boolean isOccupied(GameBlock block){

            if(block.getRow() > gameBoard.getRows()){
                return true;
            }

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
}
