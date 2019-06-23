package org.academiadecodigo.codezillas.rollBar.graphics;

import org.academiadecodigo.codezillas.rollBar.*;
import org.academiadecodigo.codezillas.rollBar.blocks.*;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Grid;
import org.academiadecodigo.codezillas.rollBar.gridRollBar.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
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
            break;

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


   public void search(BlockColor color){
      for(int i = 0; i < Game.getMatrix().length; i++){
         for(int j = 0; j < Game.getMatrix()[i].length; j++){
            if(Game.getMatrix()[i][j] == null){
               continue;
            }
            if(color.equals(Game.getMatrix()[i][j].getColor())){
               System.out.println("BOOM");
            }
         }
      }





   }





 /* public void search(Position position){
      System.out.println(position.getCol() + " " + position.getRow());
      //Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);

     if (position.getRow() - 1 > 0 // relative search UP
             && Game.getMatrix()[position.getCol()][position.getRow() - 1] != null
             && Game.getMatrix()[position.getCol()][position.getRow() - 1].getColor() == Game.getMatrix()[position.getCol()][position.getRow()].getColor()
             && (Game.getMatrix()[position.getCol()][position.getRow() - 1].isVisited() )== false) {
        Position tempPosition4 = new Position(position.getCol() + 0 , position.getRow() - 1, Game.getGameBoard());
        Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);
        search(tempPosition4);
     }
         if (position.getCol() + 1 < 9 // relative search Right)
                 && Game.getMatrix()[position.getCol() + 1][position.getRow()] != null
                 && Game.getMatrix()[position.getCol() + 1][position.getRow()].getColor() == Game.getMatrix()[position.getCol()][position.getRow()].getColor()
         && (Game.getMatrix()[position.getCol() + 1][position.getRow()].isVisited() )== false){
            Position tempPosition1 = new Position(position.getCol() + 1, position.getRow() + 0, Game.getGameBoard());
            Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);
            search(tempPosition1);
         }
          if (position.getRow() + 1 < 17 // relative search Down
                  && Game.getMatrix()[position.getCol()][position.getRow() + 1] != null
                 && Game.getMatrix()[position.getCol()][position.getRow() + 1].getColor() == Game.getMatrix()[position.getCol()][position.getRow()].getColor()
               && (Game.getMatrix()[position.getCol()][position.getRow() + 1].isVisited() ) == false) {
            Position tempPosition2 = new Position(position.getCol() + 0, position.getRow() + 1, Game.getGameBoard());
             Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);
            search(tempPosition2);
         }
         if (position.getCol() > 0 // relative search Left
                 && Game.getMatrix()[position.getCol() - 1][position.getRow()] != null
                 && Game.getMatrix()[position.getCol() - 1][position.getRow()].getColor() == Game.getMatrix()[position.getCol()][position.getRow()].getColor()
                 && (Game.getMatrix()[position.getCol() - 1][position.getRow()].isVisited() )== false) {
            Position tempPosition3 = new Position(position.getCol() - 1, position.getRow() + 0, Game.getGameBoard());
            Game.getMatrix()[position.getCol()][position.getRow()].setVisited(true);
            search(tempPosition3);
         }

      System.out.println("BOOOOOMMMM!!!!!!");





      //Game.getMatrix()[position.getCol()][position.getRow()].delete();

      //DESTROY HERE AND RETURN
   } */




}





