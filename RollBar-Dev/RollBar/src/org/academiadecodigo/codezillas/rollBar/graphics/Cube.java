package org.academiadecodigo.codezillas.rollBar.graphics;

import org.academiadecodigo.codezillas.rollBar.Breakable;
import org.academiadecodigo.codezillas.rollBar.ColorMapper;
import org.academiadecodigo.codezillas.rollBar.PuyoBreaker;
import org.academiadecodigo.codezillas.rollBar.PuyoRectangle;
import org.academiadecodigo.codezillas.rollBar.blocks.BlockColor;
import org.academiadecodigo.codezillas.rollBar.blocks.BlockType;
import org.academiadecodigo.codezillas.rollBar.blocks.Direction;
import org.academiadecodigo.codezillas.rollBar.blocks.GameBlock;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cube implements KeyboardHandler {

   private Grid grid;
   private Breakable master;
   private Breakable slave;
   private GameBlock masterBlock;
   private GameBlock slaveBlock;
   private GameBlock swapedMaster;
   private GameBlock swapedSlave;
   private BlockType blockType;
   private boolean swap;

   public Cube(Grid grid, GameBlock gameblock) {
      this.grid = grid;
      this.masterBlock = gameblock;
      this.slaveBlock = gameblock.getSlave();
      this.swapedMaster = slaveBlock;
      this.swapedSlave = masterBlock;

      greatThings(masterBlock, slaveBlock);

   //   slave = new PuyoRectangle(grid.columnToX(4), grid.rowToY(-1), grid.getCellSize(), grid.getCellSize());
     // master = new PuyoRectangle(grid.columnToX(4), grid.rowToY(0), grid.getCellSize(), grid.getCellSize());
      master.setColor(ColorMapper.getColor(gameblock.getColor()));
      slave.setColor(ColorMapper.getColor(slaveBlock.getColor()));
      show();

   }

   public void greatThings(GameBlock masterBlock, GameBlock slaveBlock){
      if (masterBlock.getBlockType() == BlockType.BREAKER){
         this.master = new PuyoBreaker(grid.columnToX(4), grid.rowToY(0), grid.getCellSize(), grid.getCellSize());
      } else if (masterBlock.getBlockType() == BlockType.BLOCK) {
         this.master = new PuyoRectangle(grid.columnToX(4), grid.rowToY(0), grid.getCellSize(), grid.getCellSize());
      }
      if (slaveBlock.getBlockType() == BlockType.BREAKER){
         this.slave = new PuyoBreaker(grid.columnToX(4), grid.rowToY(-1), grid.getCellSize(), grid.getCellSize());
      } else if (slaveBlock.getBlockType() == BlockType.BLOCK) {
         this.slave = new PuyoRectangle(grid.columnToX(4), grid.rowToY(-1), grid.getCellSize(), grid.getCellSize());
      }


   }



   private void show(){

      master.fill();
      slave.fill();

   }

   private void hide(){
      master.delete();
      slave.delete();
   }

   public void keyPressed(KeyboardEvent keyboardEvent) {
      int key = keyboardEvent.getKey();
      if (!masterBlock.isActive()){
         return;
      }
      switch (key) {
         case KeyboardEvent.KEY_LEFT:
            if (masterBlock.move(Direction.LEFT)) {
               master.translate(-grid.getCellSize(), 0);
               slave.translate(-grid.getCellSize(), 0);

               System.out.println("GAMEBlock" + masterBlock.getPosition().getCol() + " " + masterBlock.getPosition().getRow());
               break;
            }
            break;
         case KeyboardEvent.KEY_RIGHT:
            if (masterBlock.move(Direction.RIGHT)) {
               master.translate(grid.getCellSize(), 0);
               slave.translate(grid.getCellSize(), 0);


               System.out.println("GAMEBlock" + masterBlock.getPosition().getCol() + " " + masterBlock.getPosition().getRow());
               break;
            }

            case KeyboardEvent.KEY_DOWN:
               if(!swap) {
                  master.translate(0, -grid.getCellSize());
                  slave.translate(0, grid.getCellSize());
                  swapColors();
                  System.out.println("SWAP");
                  this.swap = true;
                  break;
               }

               master.translate(0, grid.getCellSize());
               slave.translate(0, -grid.getCellSize());
               swapColors();
               System.out.println("SWAP");
               this.swap = false;
               break;
      }
   }

   public void swapColors(){

      BlockColor masterBlockcolor = masterBlock.getColor();
      masterBlock.setColor(slaveBlock.getColor());
      slaveBlock.setColor(masterBlockcolor);


   }


   public void keyReleased(KeyboardEvent keyboardEvent) {



   }

   public void fall(boolean bool){
      if(bool) {
         master.translate(0, grid.getCellSize());
         slave.translate(0, grid.getCellSize());
      }
   }

   public Breakable getMaster() {
      return master;
   }

   public GameBlock getMasterBlock() {
      return masterBlock;
   }

}
