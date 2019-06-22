package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);
        this.simpleGfxGrid = grid;
        rectangle = new Rectangle(simpleGfxGrid.PADDING,simpleGfxGrid.PADDING,simpleGfxGrid.CELL_SIZE,simpleGfxGrid.CELL_SIZE);
        rectangle.draw();


        //throw new UnsupportedOperationException();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);
        simpleGfxGrid = grid;
        rectangle = new Rectangle(grid.columnToX(col)+grid.PADDING,grid.rowToY(row)+grid.PADDING,simpleGfxGrid.CELL_SIZE,simpleGfxGrid.CELL_SIZE);
        rectangle.draw();


        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.setColor(Color.RED);
        rectangle.fill();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
        //throw new UnsupportedOperationException();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int initialX = simpleGfxGrid.columnToX(super.getCol());
        int initialY = simpleGfxGrid.rowToY(super.getRow());
        super.moveInDirection(direction,distance);

        int finalX = simpleGfxGrid.columnToX(super.getCol());
        int finalY = simpleGfxGrid.rowToY(super.getRow());

        rectangle.translate(finalX -initialX,finalY - initialY);

        //throw new UnsupportedOperationException();
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
       // throw new UnsupportedOperationException();
    }
}
