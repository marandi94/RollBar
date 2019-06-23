package org.academiadecodigo.codezillas.rollBar.graphics;

import org.academiadecodigo.codezillas.rollBar.ColorMapper;
import org.academiadecodigo.codezillas.rollBar.blocks.Block;
import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.blocks.Direction;
import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cube implements KeyboardHandler {

   private Grid grid;
   private Rectangle block;
   private GameBlock gameBlock;

   public Cube(Grid grid, GameBlock gameblock) {
      this.grid = grid;
      this.gameBlock = gameblock;

      block = new Rectangle(grid.columnToX(4), grid.rowToY(0), grid.getCellSize(), grid.getCellSize());
      block.setColor(ColorMapper.getColor(gameblock.getColor()));
      show();

   }

   private void show(){

      block.fill();

   }

   private void hide(){
      block.delete();
   }

   public void keyPressed(KeyboardEvent keyboardEvent) {
      int key = keyboardEvent.getKey();
      if (!gameBlock.isActive()){
         return;
      }
      switch (key) {
         case KeyboardEvent.KEY_LEFT:
            if (gameBlock.move(Direction.LEFT)) {
               block.translate(-grid.getCellSize(), 0);
               System.out.println("GAMEBlock" + gameBlock.getPosition().getCol() + " " + gameBlock.getPosition().getRow());
               break;
            }
            break;
         case KeyboardEvent.KEY_RIGHT:
            if (gameBlock.move(Direction.RIGHT)) {
               block.translate(grid.getCellSize(), 0);
               System.out.println("GAMEBlock" + gameBlock.getPosition().getCol() + " " + gameBlock.getPosition().getRow());
               break;
            }
      }
   }



   public void keyReleased(KeyboardEvent keyboardEvent) {

   }

   public void fall(boolean bool){
      if(bool) {
         block.translate(0, grid.getCellSize());

      }
   }

   public Rectangle getCube() {
      return block;
   }

   public GameBlock getGameBlock() {
      return gameBlock;
   }
}
