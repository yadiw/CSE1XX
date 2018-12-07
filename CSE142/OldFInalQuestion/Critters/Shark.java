import java.awt.*; // for Color

public class Shark extends Critter {
     
   private int count;
   private int max;
   private boolean walkNorth;
    
   public Shark() {
      count = -1;
      max = 1;
      walkNorth = true;
   }
    
   public Direction getMove() {
      count++;
      if (count == max) {
         max++;
         count = 0;
         walkNorth = !walkNorth;
      }
      if (walkNorth) {
         return Direction.NORTH;
      } else {
         return Direction.SOUTH;
      }  
   }
}