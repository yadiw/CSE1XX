import java.util.*;
import java.awt.*;

public class Caterpillar extends Critter {
   private static final Direction[] MOVE = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
   private boolean reset; 
   private int count;
   private int max;
   
   public Caterpillar() {
      count = -1;
      max = 1;
   }
   
   public boolean eat() {
      reset = true;
      return true;
   }
   
   public Direction getMove() {
      count++;
      if (count >= max * 4) {
         max++;
         count = 0;
      }
      if (reset) {
         reset = false;
         count = 0;
         max = 1;
      }
      return MOVE[count / max];
   }

}