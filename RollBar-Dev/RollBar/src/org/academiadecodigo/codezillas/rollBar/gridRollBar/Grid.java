package org.academiadecodigo.codezillas.rollBar.gridRollBar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

    public class Grid {

        public static final int PADDING = 10;
        public static final int CELL_SIZE = 40;
        private int cols = 9;
        private int rows = 16;
        private Rectangle canvas;

        public Grid(){

            canvas = new Rectangle(PADDING,PADDING,cols*CELL_SIZE,rows*CELL_SIZE);

        }
        public void init() {

            canvas.setColor(Color.GRAY);
            canvas.draw();

        }

        public int getCols() {
            return cols;
        }

        public int getRows() {
            return rows;
        }

        public int getWidth() {
            return canvas.getWidth();
        }

        public int getHeight() {
            return canvas.getHeight();
        }

        public int getX() {
            return canvas.getX();
        }

        public int getY() {
            return canvas.getY();
        }

        public int getPADDING() {
            return PADDING;
        }

        public int getCellSize() {
            return CELL_SIZE;
        }

        public int rowToY(int row) {

            return row * CELL_SIZE + PADDING;
        }

        public int columnToX(int column) {

            return column * CELL_SIZE + PADDING;

        }

    }


