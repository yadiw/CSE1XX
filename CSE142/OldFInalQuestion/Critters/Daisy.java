import java.awt.*;

public class Daisy extends Critter {
   private static final Direction[] MOVE = {Direction.EAST, Direction.NORTH, Direction.WEST, Direction.NORTH};
   private int slowDown;
   private int index;
   private int step;
   private boolean pause;
   
   public boolean eat() {
      slowDown = 3;
      pause = true;
      return true;
   }
   
   public Direction getMove() {
      if (slowDown == 0 || !pause) {
         step++;
         if (index == 0 || index == 2) {
            if (step > 4) {
               index++;
               step = 0;
            }
         } else if (index == 1) {
            index++;
         } else {
            index = 0;
         }
         pause = true;
         return MOVE[index];
      } else {
         slowDown--;
         pause = false;
         return Direction.CENTER;
      }
   }



}