package org.academiadecodigo.codezillas.rollBar.graphics;

import org.academiadecodigo.codezillas.rollBar.blocks.Block;
import org.academiadecodigo.codezillas.rollBar.blocks.Direction;
import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cube implements KeyboardHandler {

   private Grid grid;
   private Rectangle cube;
   private GameBlock gameBlock;


   public Cube(Grid grid, Block gameblock) {
      this.grid = grid;
      this.gameBlock = gameblock;

      cube = new Rectangle(grid.columnToX(4), grid.rowToY(0), grid.getCellSize(), grid.getCellSize());
      cube.setColor(Color.CYAN);
      show();

   }

   private void show(){
      cube.fill();
   }

   private void hide(){
      cube.delete();
   }

   public void keyPressed(KeyboardEvent keyboardEvent) {
      int key = keyboardEvent.getKey();
      switch (key) {
         case KeyboardEvent.KEY_LEFT:
            cube.translate(-grid.getCellSize(),0);
            break;
         case KeyboardEvent.KEY_RIGHT:
            cube.translate(grid.getCellSize(), 0);
            break;
         case KeyboardEvent.KEY_DOWN:
            cube.translate(0, grid.getCellSize());
            break;
      }
   }



   public void keyReleased(KeyboardEvent keyboardEvent) {

   }
}
