import java.awt.*;

public class Dog001 extends Critter {
   private int count;
   private int max;
   
   public Dog001() {
      count = 0;
      max = 1;
   }
   
   public Direction getMove() {
      count++;
      if (count <= max) {
         return Direction.EAST;
      } else if (count < 2 * max) {
         return Direction.SOUTH;
      } else { // count == 2 * max
         count = 0;
         max++;
         return Direction.SOUTH;
      }
   }









}