import java.awt.*;

public class Baboon extends Critter {
   private static final Direction[] MOVE = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
   private int count;
   private int max;
    
   public Baboon() {
      max = 1;
   }

   public Direction getMove() {
      if (count == max) {
         count = 0;
         max++;
         if (max > 8) {
            max = 1;
         }
      }
      count++;
      return MOVE[(max - 1) % 4];
   }
}