package org.academiadecodigo.codezillas.rollBar.gridRollBar;

import org.academiadecodigo.codezillas.rollBar.blocks.CheckColision;

public class Position {

    private Grid grid;
    private int row;
    private int col;
    private CheckColision checkColision;



    public Position(Grid grid){


        this.grid = grid;
    }


    public int getCol() {
        return col;
    }

    public int getRow(){
        return row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Grid getGrid(){
    return grid;
    }

    public CheckColision getCheckColision(){
        return checkColision;
    }
}