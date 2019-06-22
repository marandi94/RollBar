package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 20;
    private int cols;
    private int rows;
    private Rectangle canvas;

    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        canvas = new Rectangle(PADDING,PADDING,cols*CELL_SIZE,rows*CELL_SIZE);



        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {
        canvas.setColor(Color.GRAY);
        canvas.draw();

        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() {
        return cols;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() {
        return rows;
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() {
        return canvas.getWidth();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return canvas.getHeight();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return canvas.getX();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return canvas.getY();
        //throw new UnsupportedOperationException();
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return CELL_SIZE;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        GridPosition gridPosition = new SimpleGfxGridPosition(this);
        return gridPosition;
        //throw new UnsupportedOperationException();
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        GridPosition gridPosition = new SimpleGfxGridPosition(col,row,this);
        return gridPosition;
        //throw new UnsupportedOperationException();
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return row*CELL_SIZE;
        //throw new UnsupportedOperationException();
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return column*CELL_SIZE;
        //throw new UnsupportedOperationException();
    }
}
