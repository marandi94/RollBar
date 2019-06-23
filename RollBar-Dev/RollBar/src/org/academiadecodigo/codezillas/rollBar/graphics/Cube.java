package org.academiadecodigo.codezillas.rollBar.graphics;

import org.academiadecodigo.codezillas.rollBar.ColorMapper;
import org.academiadecodigo.codezillas.rollBar.blocks.Block;
import org.academiadecodigo.codezillas.rollBar.blocks.BlockFactory;
import org.academiadecodigo.codezillas.rollBar.blocks.Direction;
import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cube implements KeyboardHandler {

   private Grid grid;
   private Rectangle cube;
   private Rectangle slave;
   private GameBlock gameBlock;
   private GameBlock slaveBlock;
   private boolean swap;

   public Cube(Grid grid, GameBlock gameblock) {
      this.grid = grid;
      this.gameBlock = gameblock;
      this.slaveBlock = gameblock.getSlave();

      slave = new Rectangle(grid.columnToX(4), grid.rowToY(-1), grid.getCellSize(), grid.getCellSize());
      cube = new Rectangle(grid.columnToX(4), grid.rowToY(0), grid.getCellSize(), grid.getCellSize());
      cube.setColor(ColorMapper.getColor(gameblock.getColor()));
      slave.setColor(ColorMapper.getColor(slaveBlock.getColor()));
      show();

   }

   private void show(){

      cube.fill();
      slave.fill();

   }

   private void hide(){
      cube.delete();
      slave.delete();
   }

   public void keyPressed(KeyboardEvent keyboardEvent) {
      int key = keyboardEvent.getKey();
      if (!gameBlock.isActive()){
         return;
      }
      switch (key) {
         case KeyboardEvent.KEY_LEFT:
            if (gameBlock.move(Direction.LEFT)) {
               cube.translate(-grid.getCellSize(), 0);
               slave.translate(-grid.getCellSize(), 0);

               System.out.println("GAMEBlock" + gameBlock.getPosition().getCol() + " " + gameBlock.getPosition().getRow());
               break;
            }
            break;
         case KeyboardEvent.KEY_RIGHT:
            if (gameBlock.move(Direction.RIGHT)) {
               cube.translate(grid.getCellSize(), 0);
               slave.translate(grid.getCellSize(), 0);

               System.out.println("GAMEBlock" + gameBlock.getPosition().getCol() + " " + gameBlock.getPosition().getRow());
               break;
            }

            case KeyboardEvent.KEY_DOWN:
               if(!swap) {
                  cube.translate(0, -grid.getCellSize());
                  slave.translate(0, grid.getCellSize());
                  System.out.println("SWAP");
                  this.swap = true;
                  break;
               }
               cube.translate(0, grid.getCellSize());
               slave.translate(0, -grid.getCellSize());
               System.out.println("SWAP");
               this.swap = false;
               break;
      }
   }



   public void keyReleased(KeyboardEvent keyboardEvent) {



   }

   public void fall(boolean bool){
      if(bool) {
         cube.translate(0, grid.getCellSize());
         slave.translate(0, grid.getCellSize());
      }
   }

   public Rectangle getCube() {
      return cube;
   }

   public GameBlock getGameBlock() {
      return gameBlock;
   }

}
